package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.ManagerAddRequestDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerAddRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class ManagerAddRequestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerAddRequestController get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_MAINTAINER_REQUEST/MANAGER_MAINTAINER_REQUEST.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerAddRequestController post method called");

        ManagerAddRequest manrequest = new ManagerAddRequest();

        HttpSession session = req.getSession();
        String manager_id = (String) session.getAttribute("MemberID");
        String branchID = (String) session.getAttribute("BranchID");

        System.out.println(branchID);
        System.out.println(manager_id);

        manrequest.setEquipment_id(req.getParameter("equipment_id"));
        manrequest.setCategory(req.getParameter("category"));
        manrequest.setDescription(req.getParameter("description"));
        manrequest.setRe_date(Date.valueOf(req.getParameter("re_date")));
        manrequest.setRe_time(LocalTime.parse(req.getParameter("re_time")));

        manrequest.setBranchmanager_id(manager_id);
        manrequest.setBranch_id(branchID);

        System.out.println("sachiiiiiiiiiiiiiiiiiiiiii");
        System.out.println(manrequest);

        boolean added = false;

        try{
            added = ManagerAddRequestDAO.addNewRequest(manrequest);

        }catch(SQLException e) {
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
