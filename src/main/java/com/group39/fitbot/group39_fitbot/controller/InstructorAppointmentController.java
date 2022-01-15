package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorAppointmentDAO;
import com.group39.fitbot.group39_fitbot.dao.InstructorStudentDAO;
import com.group39.fitbot.group39_fitbot.model.InsAppointment;
import com.group39.fitbot.group39_fitbot.model.InsStudent;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorAppointmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method call in ins student");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        List<InsAppointment> all_appointment = new ArrayList<>();
//        InsStudent student = new InsStudent();
        try {
            all_appointment = InstructorAppointmentDAO.getAppointment(memberID);
//            System.out.println("00000000000000");
            System.out.println(all_appointment);
            Gson gson = new Gson();
            String appointmentJSON = gson.toJson(all_appointment);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(appointmentJSON);


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
