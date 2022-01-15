package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorBranchIDDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

public class InstructorsLeaveFormOpenController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("call open form");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            String branch_id = InstructorBranchIDDAO.getBranchIdForIns(memberID);
            System.out.println("check branch id");
            System.out.println(branch_id);
            Gson gson = new Gson();
            String branch_idJSON = gson.toJson(branch_id);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(branch_idJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
