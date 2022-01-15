package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.InstructorLeaveSubmitDAO;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;
import com.group39.fitbot.group39_fitbot.model.InsLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;

public class InstructorsLeaveFormUpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
           System.out.println("call get method InstructorsLeaveFormSubmitController");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in submit");
        LocalDate mydate= LocalDate.now();
        System.out.println(mydate);

        InsLeave leaveForme= new InsLeave();

        leaveForme.setInstructor_id(req.getParameter("employeeName_first"));
        leaveForme.setRequest_date(Date.valueOf(req.getParameter("leave_date_second")));
        leaveForme.setBranch_id(req.getParameter("branch_name_third"));
        leaveForme.setLeave_form_date(Date.valueOf(req.getParameter("employeeFrom_Date")));
        leaveForme.setLeave_form_time(Time.valueOf(req.getParameter("employeeFrom_Time")));
        leaveForme.setLeave_to_date(Date.valueOf(req.getParameter("employeeTo_Date")));
        leaveForme.setLeave_form_time(Time.valueOf(req.getParameter("employeeTo_Time")));

        boolean addDone=false;

        try {
            addDone= InstructorLeaveSubmitDAO.submitLeaveForm(leaveForme);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (addDone){
            System.out.println("added");
        }else {
            System.out.println("not added");
        }

    }
}
