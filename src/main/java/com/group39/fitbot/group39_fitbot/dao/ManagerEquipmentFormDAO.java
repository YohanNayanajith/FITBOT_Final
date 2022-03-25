package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManagerEquipmentFormDAO {

    public ManagerEquipmentFormDAO(){

    }

    public static boolean addNewEquipment(ManagerEquipment equipment) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO equipment (equipment_id,description,category,purchase_date,last_modified_date,next_maintenance_date,branch_id) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("im sachinka");
        System.out.println(equipment);
        pst.setString(1,equipment.getEquipment_id());
        pst.setString(2,equipment.getDescription());
        pst.setString(3,equipment.getCategory());
        pst.setDate(4,equipment.getPurchase_date());
        pst.setDate(5,equipment.getLast_modified_date());
        pst.setDate(6,equipment.getNext_maintenance_date());
        pst.setString(7,equipment.getBranch_id());

        return pst.executeUpdate() > 0;
    }

    public static boolean removeEquipment(String equipment_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE equipment SET status=? WHERE equipment_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,0);
        pst.setString(2,equipment_id);
        System.out.println("Equipment Removed Successfully");

        return pst.executeUpdate() > 0;
    }

}
