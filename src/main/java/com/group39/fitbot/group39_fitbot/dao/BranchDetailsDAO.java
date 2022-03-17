package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchDetailsDAO {
    public static String retriveBranchDetails(String memberID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch.branch_id FROM branch \n" +
                "INNER JOIN register ON branch.branch_location = register.branch_name\n" +
                "WHERE register.member_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        String branchID = null;

        while (resultSet.next()) {
            if (resultSet != null) {
                branchID = resultSet.getString(1);
            }
        }

        return branchID;
    }
}
