package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.EditProfileDAO;
import com.group39.fitbot.group39_fitbot.dao.MemberInstructorDetailDAO;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

public class MemberInstructorDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor detail get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Instructor detail post method called");

        PrintWriter out = resp.getWriter();
        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String memberID = (String) session.getAttribute("MemberID");
        String memberType = (String) session.getAttribute("userType");

        System.out.println(memberType);

        MemberInstructorDetail memberInstructorDetail = new MemberInstructorDetail();
        if(Objects.equals(memberType,"physical_member")){
            try {
                memberInstructorDetail = MemberInstructorDetailDAO.getInstructorDetail(memberID);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else if(Objects.equals(memberType,"virtual_member")){
            try {
                memberInstructorDetail = MemberInstructorDetailDAO.getInstructorDetailVirtual(memberID);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if(memberInstructorDetail == null){
            resp.setContentType("text/plain");
            out.print("1");
        }else {
            System.out.println(memberInstructorDetail);
            Gson gson = new Gson();
            String registerJSON = gson.toJson(memberInstructorDetail);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(registerJSON);
        }
    }
}
