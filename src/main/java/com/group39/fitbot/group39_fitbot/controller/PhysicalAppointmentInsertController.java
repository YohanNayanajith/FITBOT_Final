package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.PhysicalAppointmentDAO;
import com.group39.fitbot.group39_fitbot.dao.WorkoutDAO;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;
import com.group39.fitbot.group39_fitbot.model.Workout;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysicalAppointmentInsertController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Insert Appointment get method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Insert Appointment post method");
        PhysicalAppointment physicalAppointment = new PhysicalAppointment();
        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");
        try {
            List<PhysicalAppointment> PhysicalAppointmentList = new ArrayList<>();
            PhysicalAppointmentList = PhysicalAppointmentDAO.getAppoitmentData(memberID);
            Gson gson = new Gson();
            String workoutJSON = gson.toJson(PhysicalAppointmentList);
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
