package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.EmployeeDAO;
import com.group39.fitbot.group39_fitbot.dao.ReportDataDAO;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.XY;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class IncomeChartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Income Chart for branches");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        System.out.println(type);

//        Employee employee = new Employee();
        try {
            List<XY> income = new ArrayList<>();
            if (Objects.equals(type,"Total")) {
                income = ReportDataDAO.getIncomeTotal();
                System.out.println(income);
            }
            else if (Objects.equals(type,"Virtual")) {
                income = ReportDataDAO.getVirtualIncome();
                System.out.println(income);
            }
            else {
                income = ReportDataDAO.getBranchIncome(type);
                System.out.println(income);
            }

            Gson gson = new Gson();
            String employeeJSON = gson.toJson(income);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(employeeJSON);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
