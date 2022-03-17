package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.NotificationDAO;
import com.group39.fitbot.group39_fitbot.model.Notification;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class NotificationSaveController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Notification save controller called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        String user_id = req.getParameter("user_id");
        String notification_title = req.getParameter("notification_title");
        LocalTime notification_time = LocalTime.parse(req.getParameter("notification_time"));
        LocalDate notification_date = LocalDate.parse(req.getParameter("notification_date"));
        String notification_type = req.getParameter("notification_type");
        int notification_status = Integer.parseInt(req.getParameter("notification_status"));

        Notification notification = new Notification();
        notification.setUser_id(user_id);
        notification.setNotification_title(notification_title);
        notification.setNotification_time(notification_time);
        notification.setNotification_date(notification_date);
        notification.setNotification_type(notification_type);
        notification.setNotification_status(notification_status);

        boolean added;
        try {
            added = NotificationDAO.insertNotificationDetails(notification);
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
