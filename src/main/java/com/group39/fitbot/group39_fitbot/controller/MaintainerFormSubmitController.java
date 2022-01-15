package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.MaintainerUpdateDAO;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class MaintainerFormSubmitController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Maintainer/FullSidebar.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        FormMaintain formSubmit=new FormMaintain();
        formSubmit.setForm_id(req.getParameter("popId"));
        formSubmit.setComplet_dis(req.getParameter("complet_dis"));
        formSubmit.setComplet_img(req.getParameter("complet_img"));
        formSubmit.setComp_date(Date.valueOf(req.getParameter("comp_date")));
        formSubmit.setComp_time(Time.valueOf(req.getParameter("comp_time")));

        System.out.println(formSubmit);
        System.out.println("in mt onr thana");

        boolean updateResult= false;

        try {
            updateResult = MaintainerUpdateDAO.updateForm(formSubmit);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(updateResult){
            System.out.println("Update database");
            out.print("1");
        }else {
            System.out.println("Not add");
            out.print("0");
        }


//        String formMaintainJSON = gson.toJson(update_form);
//        resp.setContentType("application/json");
//        resp.setCharacterEncoding("UTF-8");
//        resp.getWriter().write(formMaintain);

    }
}
