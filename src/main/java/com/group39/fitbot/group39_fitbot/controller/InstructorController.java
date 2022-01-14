package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorBranchIDDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class InstructorController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("Instructor get method called");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Instructor/FullSidebar.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor post method called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        System.out.println("Instructor post method called");
        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            String branch_id = InstructorBranchIDDAO.getBranchIdForIns(memberID);
            System.out.println(branch_id);
            System.out.println("check branch id");
            System.out.println(branch_id);

            session.setAttribute("BranchID",branch_id);
            out.print(1);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
