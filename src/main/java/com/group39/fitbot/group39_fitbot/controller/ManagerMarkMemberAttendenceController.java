package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerMarkMemberAttendenceDAO;
import com.group39.fitbot.group39_fitbot.dao.NoticeDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkMemberAttendence;
import com.group39.fitbot.group39_fitbot.model.NoticeBranchMnagaer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
//        ManagerMarkMemberAttendence markMemberAttendence = new ManagerMarkMemberAttendence();

        String memberId = req.getParameter("member_id");
        System.out.println("ammmmmmaaaaa");
        System.out.println(memberId);
        LocalDate currentDate = LocalDate.parse(req.getParameter("currentDate"));
        System.out.println(currentDate);
        LocalTime currentTime = LocalTime.parse(req.getParameter("currentTime"));
        System.out.println(currentTime);

        boolean added = false;

        try {
            added = ManagerMarkMemberAttendenceDAO.markMemberAttendence( new ManagerMarkMemberAttendence(
                    memberId,
                    currentDate,
                    currentTime,
                    1
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (added){
            System.out.println("added");
            out.print("1");
        }else {
            System.out.println("not added");
            out.print("0");
        }

//        try {
//            markMemberAttendence = ManagerMarkMemberAttendenceDAO.getManagerMarkMemberAttendence( currentDate, currentTime, memberId);
//            System.out.println(markMemberAttendence);
//            Gson gson = new Gson();
//            String attendenceJSON = gson.toJson(markMemberAttendence);
//            resp.setContentType("application/json");
//            resp.setCharacterEncoding("UTF-8");
//            resp.getWriter().write(attendenceJSON);
//
//        }catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
