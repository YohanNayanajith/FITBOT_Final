package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.EmployeeAddDAO;

import com.group39.fitbot.group39_fitbot.dao.UserAddDAO;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.Login;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.security.NoSuchAlgorithmException;

import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.obtainSHA;
import static com.group39.fitbot.group39_fitbot.controller.PasswordHashingController.toHexStr;


public class EmployeeAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Employeeadd get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin/AddEmployees/employee_add.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Employee Add Post Method Called");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");


        String type = req.getParameter("designation");
        String employee_id = req.getParameter("employee_id");
        String branch_name = req.getParameter("branch_name");
        String first_name = req.getParameter("first_name_employee");
        String last_name = req.getParameter("last_name_employee");
        String gender = req.getParameter("gender_employee");
        String email = req.getParameter("email_employee");
        String nic = req.getParameter("nic_employee");
        String dob = req.getParameter("date_of_birth_employee");

        String address = req.getParameter("address_employee");
        String primarycontact = req.getParameter("contact_no1_employee");
        String secondarycontact =req.getParameter("contact_no2_employee");
        LocalDate date_joined = LocalDate.now();



        String Maintainer = "Maintainer";
        String Branch_Manager = "Branch Manager";
        String Instructor ="Instructor";

        System.out.println(type);

        boolean added =false;



        if (Objects.equals(type, "Maintainer")){
            System.out.println("intomaintainer");
            try {
                String reg_password = toHexStr(obtainSHA(nic));
                added = EmployeeAddDAO.addMaintainer(new Employee(
                        employee_id,
                        first_name,
                        last_name,
                        gender,
                        email,
                        nic,
                        dob,
                        address,
                        primarycontact,
                        secondarycontact,
                        date_joined


                ));
                UserAddDAO.addUser(new Login(
                        email,
                        reg_password,
                        Maintainer,
                        employee_id

                ));
            } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
        }
        }

        else if (Objects.equals(type, "Instructor")){
            System.out.println("intoinstructor");
            try {
                String reg_password = toHexStr(obtainSHA(nic));
                added = EmployeeAddDAO.addInstructor(new Employee(
                        employee_id,
                        branch_name,
                        first_name,
                        last_name,
                        gender,
                        email,
                        nic,
                        dob,
                        address,
                        primarycontact,
                        secondarycontact,
                        date_joined


                ));
                UserAddDAO.addUser(new Login(
                        email,
                        reg_password,
                        Instructor,
                        employee_id

                ));
            } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
//        if (Objects.equals(type, "Branch manager"))
        else {
            System.out.println("branch_manager");
            try {
                String reg_password = toHexStr(obtainSHA(employee_id));
                added = EmployeeAddDAO.addbranchmanager(new Employee(
                        employee_id,
                        branch_name,
                        first_name,
                        last_name,
                        gender,
                        email,
                        nic,
                        dob,
                        address,
                        primarycontact,
                        secondarycontact,
                        date_joined


                ));
                UserAddDAO.addUser(new Login(
                        email,
                        reg_password,
                        Branch_Manager,
                        employee_id

                ));
            } catch (SQLException | NoSuchAlgorithmException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        if (added) {
            System.out.println("added");
//            resp.sendRedirect(req.getContextPath()+"/employee");
            out.print("1");

        }
        else {
            System.out.println("not added");
            out.print("0");
        }

    }
}
