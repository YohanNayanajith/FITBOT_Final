package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerMarkMemberAttendence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerMarkMemberAttendenceDAO {
    private static String memberId;

    public static boolean markAttendence(ManagerMarkMemberAttendence mark_mem_attendence) throws SQLException,ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO member_attendance (member_id,date,start_time,status) VALUES (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("is attendence part worked?");

        int status = 1;
        pst.setString(1,memberId);
        pst.setDate(2,mark_mem_attendence.getDate());
        pst.setTime(3,mark_mem_attendence.getStart_time());
        pst.setInt(4,status);

        return pst.executeUpdate() > 0;
}
}
