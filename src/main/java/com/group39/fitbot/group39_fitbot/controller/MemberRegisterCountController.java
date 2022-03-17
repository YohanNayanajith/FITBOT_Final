package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ReportDataDAO;
import com.group39.fitbot.group39_fitbot.model.BranchEquipmentCount;
import com.group39.fitbot.group39_fitbot.model.MemberRegisterCount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRegisterCountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Member Registartion Variation Monthly Method Called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Member RegisterCount Post Method Called");
        try {
            List<MemberRegisterCount> memberregistercount= new ArrayList<>();
            memberregistercount = ReportDataDAO.getMemberRegisterCount();
            System.out.println(memberregistercount);
            Gson gson = new Gson();
            String workoutJSON = gson.toJson(memberregistercount);
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
