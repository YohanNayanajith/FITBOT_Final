package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InsStudentBoxRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorStudentBoxDAO {
    public static List<InsStudentBoxRequest> getStudentBoxRequestData(String ins_id) throws SQLException, ClassNotFoundException{
        java.util.List<InsStudentBoxRequest> all_request = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT member_instructor_request.member_id, member_instructor_request.instructor_id, member_instructor_request.status , member.member_status FROM member_instructor_request , member WHERE member.member_id= member_instructor_request.member_id AND member.instructor_id=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, ins_id);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_request.add(new InsStudentBoxRequest(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)

                ));
            }
        }
        System.out.println(all_request);
        return all_request;
    }
}
