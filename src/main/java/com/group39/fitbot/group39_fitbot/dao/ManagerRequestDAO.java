package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerRequestDAO {
    public static List<ManagerRequest> getManagerRequest(String branchID) throws SQLException, ClassNotFoundException{
        List<ManagerRequest> manrequest = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT equipment.equipment_id,equipment.category,form.`status`,form.re_date \n" +
                "FROM (equipment\n" +
                "INNER JOIN form ON equipment.equipment_id = form.equipment_id )\n" +
                "WHERE equipment.branch_id=?\n" +
                "ORDER BY form.form_id DESC LIMIT 10";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        System.out.println("****************");
        System.out.println(manrequest);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                manrequest.add(new ManagerRequest(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getDate(4)
                ));
            }
    }
        System.out.println(manrequest);
        return manrequest;
  }
}
