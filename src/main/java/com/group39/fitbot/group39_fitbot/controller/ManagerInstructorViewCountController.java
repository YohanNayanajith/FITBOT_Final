package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerInstructorViewCountDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerInstructorViewCount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerInstructorViewCountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("instrucotr view count request get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_INSTRUCTOR/MANAGER_INSTRUCTOR.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("instrucotr view request post method called");

        LocalDate currentDate = LocalDate.parse(req.getParameter("currentDate"));

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        List<ManagerInstructorViewCount> view_count = new ArrayList<>();

        try {
            view_count = ManagerInstructorViewCountDAO.getManagerInstructorViewCount(branchID,currentDate);
            System.out.println(view_count);
            Gson gson = new Gson();
            String instructorview_countJSON = gson.toJson(view_count);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(instructorview_countJSON);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
