package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.AdminMemberDAO;
import com.group39.fitbot.group39_fitbot.dao.EmployeeDAO;
import com.group39.fitbot.group39_fitbot.dao.WorkoutDAO;
import com.group39.fitbot.group39_fitbot.model.AdminMember;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.Workout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AdminMemberController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Member get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin/Members/members.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        System.out.println(type);
        System.out.println("Member post method called");

        Workout workout = new Workout();
        try {
            List<AdminMember> all_members = new ArrayList<>();
            Employee employee = new Employee();
                if (Objects.equals(type, "All")) {
                    all_members = AdminMemberDAO.getMember();
                    System.out.println(all_members);
                } else if (Objects.equals(type, "Physical")) {
                    all_members = AdminMemberDAO.getPhysicalMember();
                    System.out.println(all_members);
                } else if (Objects.equals(type, "Virtual")) {
                    all_members = AdminMemberDAO.getVirtualMember();
                    System.out.println(all_members);
                } else if (Objects.equals(type, "Banned")) {
                    System.out.println("Into Banned");
                    all_members = AdminMemberDAO.getBannedMembers();
                    System.out.println(all_members);
                }
                System.out.println(all_members);
                Gson gson = new Gson();
                String workoutJSON = gson.toJson(all_members);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(workoutJSON);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


    }
}

