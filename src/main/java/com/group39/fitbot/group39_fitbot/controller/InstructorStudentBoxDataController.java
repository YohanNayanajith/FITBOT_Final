package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorStudentBoxDAO;
import com.group39.fitbot.group39_fitbot.model.InsStudentBoxRequest;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorStudentBoxDataController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("in box controller");
        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        List<InsStudentBoxRequest> all_request = new ArrayList<>();
        try {
            all_request = InstructorStudentBoxDAO.getStudentBoxRequestData(memberID);
            Gson gson = new Gson();
            String studentRequestJSON = gson.toJson(all_request);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(studentRequestJSON);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println("00000000000000");
//        System.out.println(all_request);



    }


}
