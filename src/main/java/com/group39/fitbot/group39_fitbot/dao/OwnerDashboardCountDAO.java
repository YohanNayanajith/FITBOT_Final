package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OwnerDashboardCountDAO {
    public static List<Integer> getDashboardCount() throws SQLException, ClassNotFoundException{
        List<Integer> ownerdashboardcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT (SELECT count(member_id) FROM register WHERE DATEDIFF(UTC_DATE(),joined_date)<31) AS NEWMEMBER,(SELECT count(member_id) FROM register) AS ALLMEMBERS,(SELECT Count(DISTINCT member_id) FROM Users WHERE user_type IN (\"Maintainer\",\"Branch Manager\",\"Instructor\") AND status=\"1\") AS ALLEMPLOYEES,(SELECT SUM(payment_amount) FROM online_payment WHERE DATEDIFF(UTC_DATE(),payment_date)<31) AS Income ;";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            ownerdashboardcount.add(resultSet.getInt(1));
            ownerdashboardcount.add(resultSet.getInt(2));
            ownerdashboardcount.add(resultSet.getInt(3));
            ownerdashboardcount.add(resultSet.getInt(4));
        }

        return ownerdashboardcount;
    }

    public static List<Integer> getAdminDashboardCount() throws SQLException, ClassNotFoundException{
        List<Integer> admindashboardcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT (SELECT count(member_id) FROM register WHERE DATEDIFF(UTC_DATE(),joined_date)<31) AS NEWMEMBER,(SELECT count(member_id) FROM register) AS ALLMEMBERS,(SELECT Count(DISTINCT member_id) FROM Users WHERE user_type IN (\"Maintainer\",\"Branch Manager\",\"Instructor\") AND status=\"1\") AS ALLEMPLOYEES,(SELECT COUNT(*) FROM branch) AS BranchCount ;";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();
        if (resultSet.next()) {
            admindashboardcount.add(resultSet.getInt(1));
            admindashboardcount.add(resultSet.getInt(2));
            admindashboardcount.add(resultSet.getInt(3));
            admindashboardcount.add(resultSet.getInt(4));
        }

        return admindashboardcount;
    }
}
