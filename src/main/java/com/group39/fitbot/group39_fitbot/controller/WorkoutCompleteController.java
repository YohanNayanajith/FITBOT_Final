package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.WorkoutDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class WorkoutCompleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WorkoutCompleteController post called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String memberID = (String) session.getAttribute("MemberID");
        String memberType = (String) session.getAttribute("userType");

        String workout_id = req.getParameter("workout_id");

        try {
            boolean added = WorkoutDAO.addCompleteExerciseData(memberID,workout_id);
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
