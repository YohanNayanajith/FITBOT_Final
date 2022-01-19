package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerEquipmentFormDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

public class ManagerEquipmentFormController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("equipment form get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_NOTICES/MANAGER_ADD_NEW_EQUIPMENT.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ManagerEquipment equipment = new ManagerEquipment();

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        equipment.setEquipment_id(req.getParameter("equipment_id"));
        equipment.setDescription(req.getParameter("description"));
        equipment.setCategory(req.getParameter("category"));
        equipment.setPurchase_date(Date.valueOf((req.getParameter("purchase_date"))));
        equipment.setLast_modified_date(Date.valueOf((req.getParameter("last_modified_date"))));
        equipment.setNext_maintenance_date(Date.valueOf((req.getParameter("next_maintenance_date"))));
        equipment.setBranch_id(branchID);

        System.out.println(equipment);

        boolean added = false;

        try {
            added = ManagerEquipmentFormDAO.addNewEquipment(equipment);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }


        if(added) {
            System.out.println("added");
        }else {
            System.out.println("not added");
        }


    }
}

