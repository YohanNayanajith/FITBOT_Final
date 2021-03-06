package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.WorkoutDAO;
import com.group39.fitbot.group39_fitbot.model.Workout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VirtualWorkoutPlanController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Virtual Workout Get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Physical Member/FullSidebar.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Virtual Workout Post method called");

        int package_id = Integer.parseInt(req.getParameter("num_plan"));
//        Workout virtual_workout = new Workout();
        try {
            List<Workout> all_workouts = new ArrayList<>();
            all_workouts = WorkoutDAO.getVirtualWorkout(package_id,"virtual");
//            System.out.println(all_workouts);
            Gson gson = new Gson();
            String workoutJSON = gson.toJson(all_workouts);
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
