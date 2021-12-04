package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MedicalFormDAO;
import com.group39.fitbot.group39_fitbot.dao.PhysicalAppointmentDAO;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PhysicalAppointmentController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Appointment get method");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Appointment post method");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        LocalDate edit_profile_container_detail_name = LocalDate.parse(req.getParameter("edit_profile_container_detail_name"));
        String edit_profile_container_detail_last_name = req.getParameter("edit_profile_container_detail_last_name");
        LocalTime edit_profile_container_detail_weight = LocalTime.parse(req.getParameter("edit_profile_container_detail_weight"));
        LocalTime edit_profile_container_detail_last_height = LocalTime.parse(req.getParameter("edit_profile_container_detail_last_height"));

        PhysicalAppointment physicalAppointment = new PhysicalAppointment();
        physicalAppointment.setAppointment_date(edit_profile_container_detail_name);
        physicalAppointment.setMember_id(memberID);
        physicalAppointment.setEquipment(edit_profile_container_detail_last_name);
        physicalAppointment.setStart_time(edit_profile_container_detail_weight);
        physicalAppointment.setFinish_time(edit_profile_container_detail_last_height);

        boolean added;
        try {
            added = PhysicalAppointmentDAO.addAppointmentDetails(physicalAppointment);
            if(added){
                System.out.println("appointment data added");
                out.print("1");
            }else {
                System.out.println("appointment data not added");
                out.print("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
