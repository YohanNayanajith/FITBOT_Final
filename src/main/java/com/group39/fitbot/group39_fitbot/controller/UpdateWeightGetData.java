package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.EditProfileDAO;
import com.group39.fitbot.group39_fitbot.dao.PhysicalInstructorDAO;
import com.group39.fitbot.group39_fitbot.model.PhysicalInstructor;
import com.group39.fitbot.group39_fitbot.model.UpdateWeight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateWeightGetData extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Update weight insert get method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Update weight insert post method");

        PrintWriter out = resp.getWriter();
        List<UpdateWeight> UpdateWeightList = new ArrayList<>();

//        PhysicalInstructor physicalInstructor = null;
        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");
        try {
            UpdateWeightList = EditProfileDAO.retriveUpdateWeight(memberID);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String updateWeightListJSON = gson.toJson(UpdateWeightList);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(updateWeightListJSON);
    }
}
