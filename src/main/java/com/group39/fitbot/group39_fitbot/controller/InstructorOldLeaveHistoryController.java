package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.InstructorLeaveHistoryDAO;
import com.group39.fitbot.group39_fitbot.model.InsLeave;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorOldLeaveHistoryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method call in old leave");

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");
        List<InsLeave> All_leave_request = new ArrayList<>();

        try {
            All_leave_request = InstructorLeaveHistoryDAO.getOldInsLeaveRequest(memberID);
            System.out.println(All_leave_request);
            Gson gson = new Gson();
            String studentJSON = gson.toJson(All_leave_request);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(studentJSON);

//            HttpSession session = req.getSession(true);
//            session.setAttribute("MemberID",loginData.getMember_id());


            

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
