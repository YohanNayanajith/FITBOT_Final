package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.EditProfileDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

@MultipartConfig

public class SaveImageDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Save image controller called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        Part imageData = req.getPart("edit_profile_container_detail_last_profile_image");
        //InputStream filename = imageData.getInputStream();
        System.out.println("Yohan image"+imageData);
        //System.out.println("Yohan image"+imageData.getInputStream());

        HttpSession session = req.getSession();
        String memberID = (String) session.getAttribute("MemberID");

        try {
            boolean accept_new = EditProfileDAO.updateLoginDetails(memberID,imageData);
            if(accept_new){
                out.print("1");
            }else{
                out.print("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
