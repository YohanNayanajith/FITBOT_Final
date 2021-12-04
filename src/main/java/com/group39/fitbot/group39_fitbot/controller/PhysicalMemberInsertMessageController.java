package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.model.PhysicalMemberMessage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import static com.group39.fitbot.group39_fitbot.dao.PhysicalMemberMessageDAO.insertMessageDetails;

public class PhysicalMemberInsertMessageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Insert Message get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Insert Message post method called");

        PrintWriter out = resp.getWriter();

        String globalInstructorID = req.getParameter("globalInstructorID");
        String messageValue = req.getParameter("messageValue");
        LocalDate fullDate = LocalDate.parse(req.getParameter("fullDate"));
        LocalTime fullTime = LocalTime.parse(req.getParameter("fullTime"));
        int messageStatus = Integer.parseInt(req.getParameter("messageStatus"));

        PhysicalMemberMessage physicalMemberMessage = new PhysicalMemberMessage();

        physicalMemberMessage.setMessage_description(messageValue);
        physicalMemberMessage.setMessage_date(fullDate);
        physicalMemberMessage.setMessage_time(fullTime);
        physicalMemberMessage.setMessage_status(messageStatus);

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            boolean b = insertMessageDetails(memberID, globalInstructorID, physicalMemberMessage);
            resp.setContentType("text/plain");
            resp.setCharacterEncoding("UTF-8");
            if(b){
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
