package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructorBranchIDDAO {
    public static String getBranchIdForIns(String instructor_id) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch_id FROM instructor WHERE instructor_id=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, instructor_id);

        ResultSet resultSet = pst.executeQuery();
        String branch_id = resultSet.getString(1);


        return branch_id;
    }
}
