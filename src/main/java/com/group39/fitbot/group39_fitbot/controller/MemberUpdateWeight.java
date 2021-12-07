package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.EditProfileDAO;
import com.group39.fitbot.group39_fitbot.model.Registartion;
import com.group39.fitbot.group39_fitbot.model.UpdateWeight;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;

public class MemberUpdateWeight extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Weight update get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Weight update post method called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");
        double weightVal = Double.parseDouble(req.getParameter("weightVal"));
        LocalDate currentDate = LocalDate.parse(req.getParameter("currentDate"));
        double previous_weight = Double.parseDouble(req.getParameter("previous_weight"));
//        double new_weight = Double.parseDouble(req.getParameter("new_weight"));

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        UpdateWeight updateWeight = new UpdateWeight();
        updateWeight.setMember_id(memberID);
        updateWeight.setUpdate_date(currentDate);
        updateWeight.setPrevious_weight(previous_weight);
        updateWeight.setNew_weight(weightVal);
        updateWeight.setDaily_count(1);

        boolean accept;
        try {
            accept = EditProfileDAO.updateWeightDetails(updateWeight);

            if(accept){
                out.print("1");
            }else {
                out.print("0");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
