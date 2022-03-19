package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.AdminMemberDAO;
import com.group39.fitbot.group39_fitbot.dao.UserAddDAO;
import com.group39.fitbot.group39_fitbot.model.BannedMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

public class UnBanMemberController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("UnBan member get Method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        System.out.println("Ban Member Post method called");

        String member_id = req.getParameter("member_id");
        String banned_reason = req.getParameter("banned_reason");
        LocalDate banned_date = LocalDate.now();

        boolean unremoved = false;
        try {
            unremoved = UserAddDAO.unbanUser(member_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (unremoved) {
            System.out.println("unbanned");
            out.print("1");

        }
        else {
            System.out.println("not unbanned");
            out.print("0");
        }

    }
}
