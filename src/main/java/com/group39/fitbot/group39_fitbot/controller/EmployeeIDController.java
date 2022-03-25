package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.EmployeeCountDAO;
import com.group39.fitbot.group39_fitbot.dao.GetMemberCountDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class EmployeeIDController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("EmployeeID Method Called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String employee_id = null;

        String designation = req.getParameter("designation");

        try {
            if(Objects.equals(designation, "Instructor")){
                int employeeCount = EmployeeCountDAO.getInstructorCount();
                employee_id = "Ins"+(employeeCount+1);
            } else if(Objects.equals(designation, "Maintainer")){
                int employeeCount = EmployeeCountDAO.getMaintainerCount();
                employee_id = "Man"+(employeeCount+1);
            } else {
                int employeeCount = EmployeeCountDAO.getBranchManagerCount();
                employee_id = "Bma"+(employeeCount+1);
            }

            Gson gson = new Gson();
            String employeeJSON = gson.toJson(employee_id);
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
