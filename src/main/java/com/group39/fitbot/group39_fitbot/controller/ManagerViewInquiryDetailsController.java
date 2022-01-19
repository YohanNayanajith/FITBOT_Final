package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerViewInquiryDAO;
import com.group39.fitbot.group39_fitbot.dao.ManagerViewInquiryDetailsDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerViewInquiry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerViewInquiryDetailsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerViewInquiryDetailsController get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_INQUIRIES/MANAGER_INQUIRIES.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ManagerViewInquiryDetailsController post method called");

        String inquiryID = req.getParameter("inquiry_id");
        HttpSession session = req.getSession();
        String managerId = (String) session.getAttribute("MemberID");
        String branchID = (String) session.getAttribute("BranchID");

        System.out.println(inquiryID);
        System.out.println(managerId);
        System.out.println(branchID);

        List<ManagerViewInquiry> view_inquiry = new ArrayList<>();

        try{
            view_inquiry = ManagerViewInquiryDetailsDAO.getManagerViewInquiryDetails(managerId,branchID,inquiryID);
            System.out.println(view_inquiry);
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa");
            Gson gson = new Gson();
            String viewinquiryJSON = gson.toJson(view_inquiry);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(viewinquiryJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
