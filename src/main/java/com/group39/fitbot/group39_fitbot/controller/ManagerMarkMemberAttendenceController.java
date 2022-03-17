package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerMarkMemberAttendenceDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkMemberAttendence;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class ManagerMarkMemberAttendenceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkMemberAttendence get method calleed");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_MEMBER/MANAGER_MEMBER.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkMemberAttendence get method calleed");

        LocalDate currentDate = LocalDate.parse(req.getParameter("currentDate"));
        LocalTime currentTime = LocalTime.parse(req.getParameter("currentTime"));

        String memberId = req.getParameter("member_id");
        System.out.println(memberId);
        System.out.println("pansilu");

        ManagerMarkMemberAttendence mark_mem_attendence = new ManagerMarkMemberAttendence();

//        mark_mem_attendence.setMember_id(req.getParameter("member_id"));
        mark_mem_attendence.setDate(Date.valueOf(req.getParameter("date")));
        mark_mem_attendence.setStart_time(Time.valueOf(req.getParameter("start_time")));
        mark_mem_attendence.setStatus(Integer.parseInt(req.getParameter("status")));

        boolean added = false;

        try {
            added = ManagerMarkMemberAttendenceDAO.markAttendence(mark_mem_attendence);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(added) {
            System.out.println("added");
        }else {
            System.out.println("not added");
        }

    }
}
