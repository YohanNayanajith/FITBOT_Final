package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorDescriptionView;
import com.group39.fitbot.group39_fitbot.model.InstructorLanguagesSkills;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorLanguagesController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InstructorLanguages get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InstructorLanguages post method called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        String instructor_id = req.getParameter("instructor_id");

        List<InstructorLanguagesSkills> instructorLanguagesSkills = new ArrayList<>();

        try {
            instructorLanguagesSkills = MemberInstructorDetailDAO.getInstructorLanguageDetail(instructor_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Gson gson = new Gson();
        String registerJSON = gson.toJson(instructorLanguagesSkills);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(registerJSON);
    }
}
