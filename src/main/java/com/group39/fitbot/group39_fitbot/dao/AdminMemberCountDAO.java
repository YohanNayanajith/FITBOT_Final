package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.AdminMember;

import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.EmployeeCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminMemberCountDAO {
    public static List<Integer> getAdminMemberCount() throws SQLException, ClassNotFoundException{
        List<Integer> adminmembercount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "Select  count(member_id) from users where user_type=\"Physical\" OR user_type=\"Virtual\" GROUP BY user_type,status ORDER BY user_type";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();
        while (resultSet.next()) {
            if (resultSet!=null) {
                adminmembercount.add(resultSet.getInt(1));
            }

        }
        return adminmembercount;
    }
}
