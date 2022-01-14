package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerEquipment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentUpcomingMaintainDAO {
    public static List<ManagerEquipment> getEquipment(String branchID) throws SQLException, ClassNotFoundException {
        List<ManagerEquipment> maintain = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM equipment \n" +
                "WHERE ((next_maintenance_date = '2022/01/06') AND branch_id=?)\n" +
                "ORDER BY equipment_id DESC LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        System.out.println("****************");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                maintain.add(new ManagerEquipment(
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
        System.out.println(maintain);
        return maintain;
    }
}

