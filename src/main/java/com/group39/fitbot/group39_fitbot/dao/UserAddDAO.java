package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserAddDAO {
        public static boolean addUser (Login user) throws SQLException, ClassNotFoundException{
            Connection connection= DBConnection.getInstance().getConnection();
            String query = "INSERT INTO users VALUES (?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setString(1, user.getUser_name());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getUserType());
            pst.setString(4, user.getMember_id());
            pst.setInt(5, 1);
            return pst.executeUpdate()>0;


        }

    public static boolean banUser(String member_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET status=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,0);
        pst.setString(2,member_id);
        System.out.println("Member banned Successfully");

        return pst.executeUpdate() > 0;
    }

    public static boolean unbanUser(String member_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET status=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,1);
        pst.setString(2,member_id);
        System.out.println("Member unbanned Successfully");

        return pst.executeUpdate() > 0;
    }
}
