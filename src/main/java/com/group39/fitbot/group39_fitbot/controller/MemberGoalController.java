package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MemberGoalDAO;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.MemberGoal;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

public class MemberGoalController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Member goal get controller called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Member goal post controller called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        double weight =  Double.parseDouble(req.getParameter("profile_physical_container_edit_monthly_goal_input1"));
        double calory = Double.parseDouble(req.getParameter("profile_physical_container_edit_monthly_goal_input2"));

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        MemberGoal memberGoal = new MemberGoal();
        MemberGoal memberGoal1 = new MemberGoal();

        memberGoal1.setMember_id(memberID);
        memberGoal1.setWeight_goal(weight);
        memberGoal1.setCalory_goal(calory);

        boolean added;

        try {
            memberGoal = MemberGoalDAO.selectMemberGoalDetails(memberID);

            if(memberGoal!=null){
                if(weight == 0){
                    added = MemberGoalDAO.updateMemberGoalDetailsCalory(memberGoal1);
                }else{
                    added = MemberGoalDAO.updateMemberGoalDetailsWeight(memberGoal1);
                }
            }else{
                if(weight == 0){
                    added = MemberGoalDAO.insertMemberGoalDetailsCalory(memberGoal1);
                }else{
                    added = MemberGoalDAO.insertMemberGoalDetailsWeight(memberGoal1);
                }
            }

            if(added){
                out.print("1");
            }else{
                out.print("0");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
