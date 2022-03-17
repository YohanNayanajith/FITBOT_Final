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
        String query = "Select (Select  count(member_id) from users where user_type=\"Physical\" AND status = '1' GROUP BY user_type) AS column1,(Select COALESCE(count(member_id),0) from users where user_type=\"Virtual\" AND status = '1' GROUP BY user_type) AS Column2,(Select  count(member_id) from users where status=\"0\" AND user_type=\"Physical\" OR user_type=\"Virtual\" ) AS column3";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();
            if (resultSet.next()) {
                adminmembercount.add(resultSet.getInt(1));
                adminmembercount.add(resultSet.getInt(2));
                adminmembercount.add(resultSet.getInt(3));
            }

        return adminmembercount;
    }
}
