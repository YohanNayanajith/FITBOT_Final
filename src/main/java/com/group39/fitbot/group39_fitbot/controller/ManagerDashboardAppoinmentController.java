package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerDashboardAppoinmentDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAppoinment;

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

public class ManagerDashboardAppoinmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerDashboardAppoinmentController get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_DASHBOARD/MANAGER_DASHBOARD.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerDashboardAppoinmentController post method called");

        LocalDate today = LocalDate.parse(req.getParameter("today"));

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        List<ManagerDashboardAppoinment> dash_appoinment = new ArrayList<>();
        try{
            dash_appoinment = ManagerDashboardAppoinmentDAO.getManagerDashboardAppoinment(branchID,today);
            System.out.println(dash_appoinment);
            Gson gson = new Gson();
            String appoinmentJSON = gson.toJson(dash_appoinment);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(appoinmentJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
