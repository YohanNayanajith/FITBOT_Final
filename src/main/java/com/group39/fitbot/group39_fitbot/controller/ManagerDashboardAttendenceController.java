package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerDashboardAttendenceDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAttendence;

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
import java.util.Date;
import java.util.List;

public class ManagerDashboardAttendenceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerDashboardAttendence get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_DASHBOARD/MANAGER_DASHBOARD.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerDashboardAttendence post method called");

        LocalDate fullDate = LocalDate.parse(req.getParameter("fullDate"));
        LocalDate firstdate = LocalDate.parse(req.getParameter("firstdate"));
        LocalDate lastdate = LocalDate.parse(req.getParameter("lastdate"));

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        List<ManagerDashboardAttendence> dash_attendence = new ArrayList<>();

        try{
            dash_attendence = ManagerDashboardAttendenceDAO.getManagerDashboardAttendence(branchID,firstdate,lastdate,fullDate);
            System.out.println(dash_attendence);
            Gson gson = new Gson();
            String attendenceJSON = gson.toJson(dash_attendence);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(attendenceJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}
