package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.WorkoutDAO;
import com.group39.fitbot.group39_fitbot.model.WorkoutPlanRequests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

public class WorkoutPlanRequestsController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("WorkoutPlanRequestsController called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String instructor_id = req.getParameter("user_id"); //instructor_id
        int has_assign = Integer.parseInt(req.getParameter("has_assign"));
        LocalDate request_date = LocalDate.parse(req.getParameter("request_date"));

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        WorkoutPlanRequests workoutPlanRequests = new WorkoutPlanRequests(instructor_id,has_assign,request_date,memberID);

        try {
            int hasAssign = WorkoutDAO.checkWorkoutRequestDetails(memberID,instructor_id);

            if(hasAssign == 0){
                //already sent a request to get workout plan
                out.print("2");
            }else if(hasAssign == 1){
                //new request (but table exist one or more requests)
                boolean added = WorkoutDAO.insertWorkoutRequestDetails(workoutPlanRequests);

                if(added){
                    out.print("1");
                }else {
                    out.print("0");
                }
            }else{
                //new request
                boolean added = WorkoutDAO.insertWorkoutRequestDetails(workoutPlanRequests);

                if(added){
                    out.print("1");
                }else {
                    out.print("0");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
