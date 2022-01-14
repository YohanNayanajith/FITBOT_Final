package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InsLeave;
import com.group39.fitbot.group39_fitbot.model.InsStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorLeaveHistoryDAO {

    public static List<InsLeave> getOldInsLeaveRequest(String MemberId) throws SQLException, ClassNotFoundException {
        System.out.println("in leave DAO");

        List<InsLeave> old_leave_list = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM instructor_leave WHERE instructor_id=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, MemberId);

        ResultSet resultSet = pst.executeQuery();
        System.out.println("in leave DAO");
        while (resultSet.next()) {
            if(resultSet != null) {
                old_leave_list.add(new InsLeave(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5),
                        resultSet.getTime(6),
                        resultSet.getDate(7),
                        resultSet.getTime(8)
                ));
            }
        }
        System.out.println(old_leave_list);
        return old_leave_list;
    }
}
