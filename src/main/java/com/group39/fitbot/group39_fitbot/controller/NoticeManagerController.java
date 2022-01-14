package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.NoticeDAO;
import com.group39.fitbot.group39_fitbot.model.NoticeBranchMnagaer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;

public class NoticeManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("notice get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_NOTICES/MANAGER_NOTICES.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String branchmanager_id = (String) session.getAttribute("MemberID");
        System.out.println(branchmanager_id);

        String title = req.getParameter("title");
        Date dates = Date.valueOf((req.getParameter("dates")));
        String description = req.getParameter("description");
        String manager_id = branchmanager_id;
        System.out.println( title + " "+ dates + " " + description + " " + manager_id);

        boolean added = false;

        try {
            added = NoticeDAO.addNotice( new NoticeBranchMnagaer(

                    title,
                    dates,
                    description,
                    manager_id
            ));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        if (added){
            System.out.println("added");
        }else {
            System.out.println("not added");
        }



    }
}
