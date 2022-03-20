package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MemberGoalDAO;
import com.group39.fitbot.group39_fitbot.model.MemberGoal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class MemberGoalGetDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("MemberGoalGetDataController post method called");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        MemberGoal memberGoal = new MemberGoal();
        try {
            memberGoal = MemberGoalDAO.selectMemberGoalDetails(memberID);

            Gson gson = new Gson();
            String paymentJSON = gson.toJson(memberGoal);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(paymentJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
