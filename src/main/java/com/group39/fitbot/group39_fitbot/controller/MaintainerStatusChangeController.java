package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MaintainerStatusDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class MaintainerStatusChangeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method in status change call");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post method in status change call");
        PrintWriter out = resp.getWriter();
        String form_id = req.getParameter("fid");


        System.out.println("form id in controller "+form_id);
        resp.setContentType("text/plain");

        boolean statusChange=false;

        try {
            statusChange = MaintainerStatusDAO.setFormMaintainer(form_id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(statusChange){
//            System.out.println("Update database");
            out.print("1");
        }else {
//            System.out.println("Not add");
            out.print("0");
        }


    }
}
