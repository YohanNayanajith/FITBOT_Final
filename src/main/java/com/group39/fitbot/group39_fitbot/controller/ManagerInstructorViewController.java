package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerInstructorViewDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerInstructorView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerInstructorViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("instrucotr view request get method called");
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
//        System.out.println(today);

        List<ManagerInstructorView> view_instrucotr = new ArrayList<>();

        try{
            view_instrucotr = ManagerInstructorViewDAO.getManagerInstructorView(branchID,currentDate);
            System.out.println(view_instrucotr);
            Gson gson = new Gson();
            String instructorviewJSON = gson.toJson(view_instrucotr);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(instructorviewJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
