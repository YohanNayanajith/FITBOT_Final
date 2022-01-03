package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorDescriptionView;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class InstructorDescriptionViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor Description Controller get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor Description Controller post method called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        String instructor_id = req.getParameter("instructor_id");

        InstructorDescriptionView instructorDescriptionView = new InstructorDescriptionView();
        try {
            instructorDescriptionView = MemberInstructorDetailDAO.getInstructorDetailViewDescription(instructor_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String registerJSON = gson.toJson(instructorDescriptionView);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(registerJSON);
    }
}
