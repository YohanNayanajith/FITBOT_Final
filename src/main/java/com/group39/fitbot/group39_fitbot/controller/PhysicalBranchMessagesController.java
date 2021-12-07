package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.PhysicalAppointmentDAO;
import com.group39.fitbot.group39_fitbot.dao.PhysicalBranchMessagesDAO;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;
import com.group39.fitbot.group39_fitbot.model.PhysicalBranchMessages;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysicalBranchMessagesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Branch messages get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Branch messages post method called");
        try {
            List<PhysicalBranchMessages> physicalBranchMessagesList = new ArrayList<>();
            physicalBranchMessagesList = PhysicalBranchMessagesDAO.getBranchMessagesData();
            Gson gson = new Gson();
            String workoutJSON = gson.toJson(physicalBranchMessagesList);
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
