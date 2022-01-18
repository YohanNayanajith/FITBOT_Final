package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerDashboardDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboard;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDashboardController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("manager dashboard get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_DASHBOARD/MANAGER_DASHBOARD.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("manager dashboard post method called");

        List<ManagerDashboard> mandashboard = new ArrayList<>();

        HttpSession session = req.getSession();
        String branchmanager_id = (String) session.getAttribute("MemberID");

//        System.out.println(branchID);
        System.out.println(branchmanager_id);

        try{
            mandashboard = ManagerDashboardDAO.getManagerDashboard(branchmanager_id);
            System.out.println(mandashboard);
            Gson gson = new Gson();
            String dashoboardJSON = gson.toJson(mandashboard);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(dashoboardJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
