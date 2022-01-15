package com.group39.fitbot.group39_fitbot.controller;

import com.google.gson.Gson;
//import com.group39.fitbot.group39_fitbot.dao.EquipmentDAO;
import com.group39.fitbot.group39_fitbot.dao.MaintainerEquipmentDAO;
import com.group39.fitbot.group39_fitbot.model.Equipment;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintainerEquipmentController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Maintainer/FullSidebar.html");
        requestDispatcher.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post method call in maintainer equipments");
        String List_order= req.getParameter("List_order");
        String Branch_selecter= req.getParameter("Branch_selecter");
        String Equipments_id= req.getParameter("Equipments_id");
        System.out.println(List_order);
        System.out.println(Branch_selecter);
        System.out.println(Equipments_id);

        if(Equipments_id.equals("")){
            System.out.println("Equipments Id is null");
            Equipments_id ="0000";
            System.out.println(Equipments_id);
        }
//        if(Equipments_id.equals(null)){
//            System.out.println("all print ");
//        }
        List<Equipment>all_Equipments = new ArrayList<>();
        try {
            all_Equipments = MaintainerEquipmentDAO.getEquipmentList(List_order,Branch_selecter,Equipments_id);
            Gson gson = new Gson();
            String equipmentsJSON = gson.toJson(all_Equipments);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(equipmentsJSON);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
