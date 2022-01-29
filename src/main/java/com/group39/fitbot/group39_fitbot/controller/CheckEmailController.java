package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.CheckEmailDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class CheckEmailController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Check email servlet called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        String user_email = req.getParameter("user_email");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        boolean accept = false;

        try {
            accept = CheckEmailDAO.checkEmailDetail(user_email);

            if(accept){
                //exist repeat emails
                System.out.println("Accepted");
                out.println("1");
            }else{
                System.out.println("Not Accepted");
                out.println("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
