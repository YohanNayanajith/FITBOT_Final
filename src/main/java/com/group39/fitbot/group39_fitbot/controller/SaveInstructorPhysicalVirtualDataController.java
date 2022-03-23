package com.group39.fitbot.group39_fitbot.controller;

import com.group39.fitbot.group39_fitbot.dao.SaveInstructorPhysicalVirtualDataDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class SaveInstructorPhysicalVirtualDataController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("SaveInstructorPhysicalVirtualDataController post called");

        PrintWriter out = resp.getWriter();
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String userName = (String) session.getAttribute("userName");
        String memberID = (String) session.getAttribute("MemberID");
        String memberType = (String) session.getAttribute("userType");

        String instructor_id = req.getParameter("instructor_id");

        try {
            String branchID = SaveInstructorPhysicalVirtualDataDAO.getMemberBranchDetails(memberID);
            System.out.println(branchID);
            if(memberType.equals("virtual_member")){
                System.out.println("virtual_member");
                boolean added = SaveInstructorPhysicalVirtualDataDAO.virtualTableInsertData(memberID,instructor_id);
                if(added){
                    out.print("1");
                }else{
                    out.print("0");
                }

            }else if(memberType.equals("physical_member")){
                System.out.println("physical_member");
                boolean added = SaveInstructorPhysicalVirtualDataDAO.physicalTableInsertData(memberID,instructor_id,branchID);
                if(added){
                    out.print("1");
                }else{
                    out.print("0");
                }
            }else {
                System.out.println("wrong_member");
                out.print("0");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
