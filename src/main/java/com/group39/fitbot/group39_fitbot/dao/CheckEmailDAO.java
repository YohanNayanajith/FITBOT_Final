package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckEmailDAO {
    public static boolean checkEmailDetail(String userEmail) throws SQLException, ClassNotFoundException {
        Login login = new Login();
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT user_name FROM users WHERE user_name =?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,userEmail);

        ResultSet resultSet = pst.executeQuery();

        boolean added = false;

        if(resultSet.next()){
            login.setUser_name(resultSet.getString(1));
            System.out.println("Check Added1"+added);
            added = true;
        }
        System.out.println("Check Added2"+added);
        return added;
    }
}
