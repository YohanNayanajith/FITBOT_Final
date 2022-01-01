package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.NotificationDAO;
import com.group39.fitbot.group39_fitbot.dao.PhysicalPaymentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class UpdateNotificationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Notification update get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Notification update post method called");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        int notification_id = Integer.parseInt(req.getParameter("notification_id"));

        try {
            boolean b = NotificationDAO.updateNotificationDetails(notification_id);

            resp.setCharacterEncoding("UTF-8");
            if(b){
                System.out.println("notification status updated");
                out.print("1");
            }else {
                System.out.println("notification status not updated");
                out.print("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
