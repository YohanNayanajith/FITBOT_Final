package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.RegistartionDAO;
import com.group39.fitbot.group39_fitbot.model.EmailUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class EmailVerifyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Verify controller called");

//        String verify_code = req.getParameter("verify_code");

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {

            HttpSession session = req.getSession();
            EmailUser user= (EmailUser) session.getAttribute("authcode");

            String code = req.getParameter("verify_code");

            if(code.equals(user.getCode())){
                out.println("1");
//                out.println("Verification Done");
            }else{
                try {
                    RegistartionDAO.addRegistrationToUserTableStatus();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                out.println("1");
//                out.println("Incorrect verification code");
            }

        }
    }
}
