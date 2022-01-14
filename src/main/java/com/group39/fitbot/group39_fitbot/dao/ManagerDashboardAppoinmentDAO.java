package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAppoinment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDashboardAppoinmentDAO {
    public static List<ManagerDashboardAppoinment> getManagerDashboardAppoinment(String branchID) throws SQLException, ClassNotFoundException {
        List<ManagerDashboardAppoinment> manAppoinment = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT paid_member.first_name ,appointment.start_time\n" +
                "FROM (paid_member\n" +
                "INNER JOIN appointment ON appointment.member_id=paid_member.member_id)\n" +
                "WHERE paid_member.branch_id=? LIMIT 7";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, branchID);
        System.out.println(branchID);
        System.out.println("how are u");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                manAppoinment.add(new ManagerDashboardAppoinment(
                        resultSet.getString(1),
                        resultSet.getTime(2)
                ));
            }
        }

        System.out.println(manAppoinment);
        return manAppoinment;
    }
}
