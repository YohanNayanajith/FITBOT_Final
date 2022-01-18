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
    public static List<ManagerMarkMemberAttendence> getManagerMarkMemberAttendence(String brnachID) throws SQLException,ClassNotFoundException{
        List<ManagerMarkMemberAttendence> all_mark_attendence = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE member_attendance SET `status`=1 WHERE attendance_id='1'";

        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()){
            if (resultSet != null){
                all_mark_attendence.add(new ManagerMarkMemberAttendence(
                        resultSet.getBoolean(1)
                ));
            }
    }
        System.out.println(all_mark_attendence);
        return all_mark_attendence;
}
}
