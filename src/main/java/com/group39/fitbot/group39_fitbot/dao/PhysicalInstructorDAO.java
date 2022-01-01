package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Membership;
import com.group39.fitbot.group39_fitbot.model.PhysicalInstructor;
import com.group39.fitbot.group39_fitbot.model.Workout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysicalInstructorDAO {
    public static List<PhysicalInstructor> physicalInstructorGetData() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        List<PhysicalInstructor> physicalInstructorList = new ArrayList<>();
        String query = "SELECT * FROM instructor";

        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

//        PhysicalInstructor physicalInstructor = new PhysicalInstructor();

        while(resultSet.next()){
            if(resultSet != null) {

                physicalInstructorList.add(new PhysicalInstructor(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getDate(7),
                        resultSet.getString(8),
                        resultSet.getInt(9),
                        resultSet.getInt(10),
                        resultSet.getString(11),
                        resultSet.getString(12)
                        ));
            }
        }
        System.out.println(physicalInstructorList);
        return physicalInstructorList;
    }
}
