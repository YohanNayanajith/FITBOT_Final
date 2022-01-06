package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorRatingDAO;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorRating;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class InstructorRatingGetController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor RatingGet get controller called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor RatingGet post controller called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        String instructor_id = req.getParameter("instructor_id");

        InstructorRating instructorRating = new InstructorRating();

        try {
            instructorRating = InstructorRatingDAO.getInstructorRating(instructor_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(instructorRating == null){
            resp.setContentType("text/plain");
            out.print("1");
        }else {
            Gson gson = new Gson();
            String registerJSON = gson.toJson(instructorRating);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(registerJSON);
        }
    }
}
