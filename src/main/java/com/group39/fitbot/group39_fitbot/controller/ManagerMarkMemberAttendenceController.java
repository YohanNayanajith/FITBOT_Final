package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerMarkMemberAttendenceDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkMemberAttendence;

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

public class ManagerMarkMemberAttendenceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkMemberAttendence get methoda calleed");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_MEMBER/MANAGER_MEMBER.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerMarkMemberAttendence get methoda calleed");

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        List<ManagerMarkMemberAttendence> mark_mem_attendence = new ArrayList<>();

        try{
            mark_mem_attendence = ManagerMarkMemberAttendenceDAO.getManagerMarkMemberAttendence(branchID);
            System.out.println(mark_mem_attendence);
            Gson gson = new Gson();
            String MarkmemberAttendenceJSON = gson.toJson(mark_mem_attendence);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(MarkmemberAttendenceJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}
