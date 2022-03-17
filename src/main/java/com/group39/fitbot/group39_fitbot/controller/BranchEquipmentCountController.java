package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ReportDataDAO;
import com.group39.fitbot.group39_fitbot.model.BranchEquipmentCount;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchEquipmentCountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Branch EquipmentCount Get Method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<BranchEquipmentCount> branchequipmentcount= new ArrayList<>();
            branchequipmentcount = ReportDataDAO.getEquipmentCount();
            System.out.println(branchequipmentcount);
            Gson gson = new Gson();
            String workoutJSON = gson.toJson(branchequipmentcount);
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
