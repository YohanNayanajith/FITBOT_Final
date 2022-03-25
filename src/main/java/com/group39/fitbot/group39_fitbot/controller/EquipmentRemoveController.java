package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.AdminMemberDAO;
import com.group39.fitbot.group39_fitbot.dao.ManagerEquipmentFormDAO;
import com.group39.fitbot.group39_fitbot.dao.UserAddDAO;
import com.group39.fitbot.group39_fitbot.model.BannedMember;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class EquipmentRemoveController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Equipment Remove get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        System.out.println("Ban Member Post method called");

        String equipment_id = req.getParameter("equipment_id");

        boolean removed1 = false;
        try {
           removed1 = ManagerEquipmentFormDAO.removeEquipment(equipment_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (removed1) {
            System.out.println("removed");
            out.print("1");

        }
        else {
            System.out.println("not removed");
            out.print("0");
        }
    }
}
