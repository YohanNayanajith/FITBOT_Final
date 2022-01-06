package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InstructorRating;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InstructorRatingDAO {
    public static boolean addInstructorRating(String instructor_id, String member_id, InstructorRating instructorRating) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        if(getInstructorRating(instructor_id) == null){
            String query = "INSERT INTO rating VALUES(?,?,?)";
            PreparedStatement pst = connection.prepareStatement(query);

            pst.setInt(1,instructorRating.getRating());
            pst.setString(2,member_id);
            pst.setString(3,instructor_id);
            return pst.executeUpdate() > 0;
        }else{
            String query = "UPDATE rating SET rating=? WHERE instructor_id=?";
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setInt(1,instructorRating.getRating());
            pst.setString(2,instructor_id);
            return pst.executeUpdate() > 0;
        }
    }

    public static InstructorRating getInstructorRating(String instructor_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT rating FROM rating WHERE instructor_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,instructor_id);

        ResultSet resultSet = pst.executeQuery();

        InstructorRating instructorRating = new InstructorRating();

        if(resultSet.next()){
            instructorRating.setRating(resultSet.getInt(1));
            return instructorRating;
        }else {
            return null;
        }
    }
}
