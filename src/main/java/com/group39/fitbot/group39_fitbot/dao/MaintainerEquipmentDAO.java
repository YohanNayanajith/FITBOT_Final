package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Equipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintainerEquipmentDAO {
    public String query;
    public static List<Equipment> getEquipmentList(String List_order,String Branch_selecter,String Equipments_id) throws SQLException, ClassNotFoundException {
//        System.out.println("in equipmentsDAO");
        List<Equipment> equipments = new ArrayList<>();
//        Equipment equipment = new Equipment();

        if ((Branch_selecter.equals("all")) && (Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT * FROM equipment LIMIT 10";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();
            System.out.println("all print in dao");
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7)
                    ));
                }
            }
            System.out.println(equipments);

        } else if ((!Branch_selecter.equals("all")) && (Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT * FROM equipment WHERE branch_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Branch_selecter);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7)
                    ));
                }
            }
            System.out.println(equipments);

        }else if ((Branch_selecter.equals("all")) && (!Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT * FROM equipment WHERE equipment_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Equipments_id);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7)
                    ));
                }
            }
            System.out.println(equipments);

        }else if ((!Branch_selecter.equals("all")) && (!Equipments_id.equals("0000"))) {
            Connection connection = DBConnection.getInstance().getConnection();
            System.out.println("all print in dao");
            String query = "SELECT * FROM equipment WHERE equipment_id=? AND branch_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, Equipments_id);
            pst.setString(2, Branch_selecter);

            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                if (resultSet != null) {
                    equipments.add(new Equipment(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getDate(6),
                            resultSet.getDate(7)
                    ));
                }
            }
            System.out.println(equipments);

        }else {
            System.out.println("in else");
        }
        System.out.println("before the return");
        System.out.println(equipments);
        return equipments;
    }
}
