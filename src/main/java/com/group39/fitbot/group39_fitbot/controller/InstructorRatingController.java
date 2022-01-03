package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorRatingDAO;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.InstructorLanguagesSkills;
import com.group39.fitbot.group39_fitbot.model.InstructorRating;

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

public class InstructorRatingController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor Rating get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor Rating post method called");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        String instructor_id = req.getParameter("instructor_id");
        int rating = Integer.parseInt(req.getParameter("rating"));

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        InstructorRating instructorRating = new InstructorRating(rating);

        boolean added;
        try {
            added = InstructorRatingDAO.addInstructorRating(instructor_id,memberID,instructorRating);
            if(added){
                out.print("1");
            }else{
                out.print("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
