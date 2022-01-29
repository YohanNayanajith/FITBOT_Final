package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.GetMemberCountDAO;
import com.group39.fitbot.group39_fitbot.dao.MembershipDAO;
import com.group39.fitbot.group39_fitbot.dao.RegistartionDAO;
import com.group39.fitbot.group39_fitbot.dao.SendEmailDAO;
import com.group39.fitbot.group39_fitbot.model.EmailUser;
import com.group39.fitbot.group39_fitbot.model.Membership;
import com.group39.fitbot.group39_fitbot.model.Registartion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.obtainSHA;
import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.toHexStr;
import static java.lang.Integer.parseInt;

public class RegistrationController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Registartion get contoller called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Landing/RegistrationForm/Registration.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Registartion post contoller called");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");


        String first_name = req.getParameter("first_name");
        String last_name = req.getParameter("last_name");
        LocalDate dob = LocalDate.parse(req.getParameter("date_of_birth"));
        String email = req.getParameter("email");
        int phone_number = Integer.parseInt(req.getParameter("phone_number"));
        String address = req.getParameter("address");
        String selected_country = req.getParameter("selected_country");
        String gender = req.getParameter("gender");
        String reg_password = req.getParameter("reg_password");
        String confirm_password = req.getParameter("confirm_password");
        String membership_type = req.getParameter("membership_type");
        String membership_category = req.getParameter("membership_category");
        int height = Integer.parseInt(req.getParameter("height"));
        int weight = Integer.parseInt(req.getParameter("weight"));
        String branch_type = req.getParameter("branch_type");
        LocalDate fullDate = LocalDate.parse(req.getParameter("fullDate"));
        LocalDate new_expire_date = LocalDate.parse(req.getParameter("new_expire_date"));

        String member_id = null;
        int payment_id = 0;
        int membership_id = 0;

        int renewal = 0;
        System.out.println("Renewal "+renewal);

        String has_instructor = "0";
        int instructor_price = 0;
        int discount_price = 0;

        try {
            int memberCount = GetMemberCountDAO.getMemberCount();
//            System.out.println(memberCount);
            if(Objects.equals(membership_type, "virtual_member")){
                member_id = "Vir"+(memberCount+1);
                renewal = 5000;
            }else {
                member_id = "Phy"+(memberCount+1);
                renewal = checkMembershipFee(membership_category);
            }
//            member_id = "Phy"+(memberCount+1);
            payment_id = memberCount+1;
            membership_id = memberCount+1;

            System.out.println(member_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //password hashed - SHA256
        boolean added1 = false;
        boolean added2 = false;
        boolean added3 = false;
        boolean added4 = false;
        boolean added5 = false;

        try {
            reg_password = toHexStr(obtainSHA(reg_password));
            confirm_password = toHexStr(obtainSHA(confirm_password));
            added1 = RegistartionDAO.addRegistration(new Registartion(
                            first_name,
                            last_name,
                            dob,
                            phone_number,
                            address,
                            selected_country,
                            gender,
                            reg_password,
                            confirm_password,
                            membership_type,
                            membership_category,
                            weight,
                            height,
                            member_id,
                            email,
                            branch_type
                    )

            );

            added2 = RegistartionDAO.addRegistrationToUserTable(new Registartion(
                            first_name,
                            last_name,
                            dob,
                            phone_number,
                            address,
                            selected_country,
                            gender,
                            reg_password,
                            confirm_password,
                            membership_type,
                            membership_category,
                            height,
                            weight,
                            member_id,
                            email,
                            branch_type
                    )

            );

            added3 = MembershipDAO.membershipInsertData(new Membership(
                    membership_id,
                    renewal,
                    membership_category,
                    new_expire_date,
                    renewal,
                    fullDate,
                    has_instructor,
                    instructor_price,
                    discount_price
            ));

            added4 = MembershipDAO.membershipAlterTableInsertData(member_id, membership_id, payment_id);

            added5 = processRequest(req,resp,first_name,email);

            HttpSession session = req.getSession(true);
            session.setAttribute("MemberID",member_id);
//            session.setAttribute("payment_id",member_id);
//            session.setAttribute("membership_id",member_id);

//            resp.setContentType("application/json");
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");

            System.out.println("Added1 "+added1);
            System.out.println("Added2 "+added2);
            System.out.println("Added3 "+added3);
            System.out.println("Added4 "+added4);
            System.out.println("Added5 "+added5);

            if((added1 && added2) && (added3 && added4) && added5){
                System.out.println("Added");
//            req.setAttribute("message","Successfully added");
                out.print("1");
//                resp.getWriter().write("1");
            }else if(!added5){
                System.out.println("Verify");
                out.print("2");
            }else{
                System.out.println("Not added");
//            req.setAttribute("message","Not Added");
                out.print("0");
            }

        } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    private int checkMembershipFee(String membership_category){
        if(Objects.equals(membership_category, "family_membership")){
            return 12000;
        }else if(Objects.equals(membership_category, "couple_membership")){
            return 10000;
        }else if(Objects.equals(membership_category, "platinum_membership")){
            return 8000;
        }else if(Objects.equals(membership_category, "gold_membership")){
            return 5000;
        }else if(Objects.equals(membership_category, "silver_membership")){
            return 2500;
        }else {
            return 0;
        }
    }

    private boolean processRequest(HttpServletRequest request, HttpServletResponse response,String name,String email) throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");

        System.out.println("Verify function1");
//        try (PrintWriter out = response.getWriter()) {
//
//        }
        //feth form value
        //String name = request.getParameter("username");
        //String email = request.getParameter("useremail");

        //create instance object of the SendEmail Class
        SendEmailDAO sm = new SendEmailDAO();
        System.out.println("Verify function2");
        //get the 6-digit code
        String code = sm.getRandom();
        System.out.println("Verify function3");

        //create new user using all information
        EmailUser user = new EmailUser(name,email,code);
        System.out.println("Verify function4");

        //call the send email method
        boolean test = sm.sendEmail(user);
        boolean added = false;
        System.out.println("Verify function5");

        //check if the email send successfully
        if(test){
            HttpSession session  = request.getSession();
            session.setAttribute("authcode", user);
            //response.sendRedirect("verify.jsp");

            System.out.println("Verify function6");
            added = true;
        }
        else{
//                out.println("Failed to send verification email");
            System.out.println("Verify function7");
        }
        return added;
    }
}
