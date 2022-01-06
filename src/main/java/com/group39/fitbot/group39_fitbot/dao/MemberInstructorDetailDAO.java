package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InstructorDescriptionView;
import com.group39.fitbot.group39_fitbot.model.InstructorLanguagesSkills;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberInstructorDetailDAO {
    public static MemberInstructorDetail getInstructorDetail(String memberID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM physical_member WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        MemberInstructorDetail memberInstructorDetail = new MemberInstructorDetail();

        if(resultSet.next()){
            memberInstructorDetail.setMember_id(resultSet.getString(1));
            memberInstructorDetail.setInstructor_id(resultSet.getString(2));
            memberInstructorDetail.setBranch_id(resultSet.getString(3));
            return memberInstructorDetail;
        }else {
            return null;
        }
    }

    public static MemberInstructorDetail getInstructorDetailVirtual(String memberID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM virtual_member WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        MemberInstructorDetail memberInstructorDetail = new MemberInstructorDetail();

        if(resultSet.next()){
            memberInstructorDetail.setMember_id(resultSet.getString(1));
            memberInstructorDetail.setInstructor_id(resultSet.getString(2));
            return memberInstructorDetail;
        }else {
            return null;
        }
    }

    public static InstructorDescriptionView getInstructorDetailViewDescription(String instructor_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM instructor_profile WHERE instructor_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,instructor_id);

        ResultSet resultSet = pst.executeQuery();

        InstructorDescriptionView instructorDescriptionView = new InstructorDescriptionView();

        if(resultSet.next()){
            instructorDescriptionView.setInstructor_id(resultSet.getString(1));
            instructorDescriptionView.setDescription(resultSet.getString(2));
            instructorDescriptionView.setDuration(resultSet.getInt(3));
            instructorDescriptionView.setCountry(resultSet.getString(4));
            instructorDescriptionView.setPrice(resultSet.getInt(5));
            return instructorDescriptionView;
        }else {
            return null;
        }
    }

    public static List<InstructorLanguagesSkills> getInstructorLanguageDetail(String instructor_id) throws SQLException, ClassNotFoundException {
        List<InstructorLanguagesSkills> instructorLanguagesSkills = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT language FROM instructor_languages WHERE instructor_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,instructor_id);

        ResultSet resultSet = pst.executeQuery();


        while (resultSet.next()) {
            if(resultSet != null) {
                instructorLanguagesSkills.add(new InstructorLanguagesSkills(
                        resultSet.getString(1)
                ));
            }
        }
        return instructorLanguagesSkills;
    }

    public static List<InstructorLanguagesSkills> getInstructorSkillsDetail(String instructor_id) throws SQLException, ClassNotFoundException {
        List<InstructorLanguagesSkills> instructorLanguagesSkills = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT skills FROM instructor_skills WHERE instructor_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,instructor_id);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                instructorLanguagesSkills.add(new InstructorLanguagesSkills(
                        resultSet.getString(1)
                ));
            }
        }
        return instructorLanguagesSkills;
    }
}
