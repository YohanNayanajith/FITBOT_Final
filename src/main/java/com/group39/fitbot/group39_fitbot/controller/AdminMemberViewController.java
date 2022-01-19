package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
import com.group39.fitbot.group39_fitbot.dao.AdminMemberDAO;
import com.group39.fitbot.group39_fitbot.model.AdminMember;
import com.group39.fitbot.group39_fitbot.model.BannedMember;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class AdminMemberViewController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Each MemberView get method called");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Each MemberView Post Method called");

        String member_id = req.getParameter("member_id");
        String banned_status = req.getParameter("banned_status");
        String member_type = req.getParameter("member_type");

        try {

            if (Objects.equals(banned_status,"Unbanned")) {
                System.out.println("into unbanned");
                AdminMember admin_member = new AdminMember();
                if (Objects.equals(member_type, "Physical")) {
                    System.out.println("into unbanned physical");
                   admin_member= AdminMemberDAO.retrievePhysicalMember(member_id);
                }
                else{
                    System.out.println("into unbanned virtual");
                    admin_member= AdminMemberDAO.retrieveVirtualMember(member_id);
                }
                Gson gson = new Gson();
                String adminmemberJSON = gson.toJson(admin_member);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(adminmemberJSON);
            }
            else {
                BannedMember admin_banned_member = new BannedMember();
                if (Objects.equals(member_type, "Physical")) {
                    System.out.println("into banned physical");
                    admin_banned_member=AdminMemberDAO.retrievePhysicalBanMember(member_id);
                    System.out.println(admin_banned_member);
                }
                else{
                    System.out.println("into banned virtual");
                    admin_banned_member = AdminMemberDAO.retrieveVirtualBanMember(member_id);
                    System.out.println(admin_banned_member);
                }

                Gson gson = new Gson();
                String adminmemberJSON = gson.toJson(admin_banned_member);
                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(adminmemberJSON);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

}
