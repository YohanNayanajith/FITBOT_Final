package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.ManagerMemberViewDAO;
import com.group39.fitbot.group39_fitbot.model.ManagerMemberView;

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

public class ManagerMemberViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("member view request get method called");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Manager/BRANCH_MANAGER_MEMBER/MANAGER_MEMBER.html");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("member view request post method called");

        HttpSession session = req.getSession();
        String branchID = (String) session.getAttribute("BranchID");
        System.out.println(branchID);

        List<ManagerMemberView> all_member = new ArrayList<>();

        try{
            all_member = ManagerMemberViewDAO.getManagerMemberView(branchID);
            System.out.println(all_member);
            Gson gson = new Gson();
            String memberviewJSON = gson.toJson(all_member);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(memberviewJSON);

        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
