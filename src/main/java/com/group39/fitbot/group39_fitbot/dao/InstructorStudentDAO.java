package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Equipment;
import com.group39.fitbot.group39_fitbot.model.InsStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorStudentDAO {

    public static List<InsStudent> getStudent(String MemberId) throws SQLException, ClassNotFoundException{
        System.out.println("in studentDAO");
        System.out.println(MemberId);

        List<InsStudent> all_student = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT member.first_name , member.dob , member.gender , workout_plan.plan_name , diet_plan.diet_plan_name FROM member ,workout_plan , diet_plan WHERE member.member_id=workout_plan.member_id AND member.member_id=diet_plan.member_id AND member.instructor_id=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, MemberId);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_student.add(new InsStudent(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        }


        return all_student;
    }

}
