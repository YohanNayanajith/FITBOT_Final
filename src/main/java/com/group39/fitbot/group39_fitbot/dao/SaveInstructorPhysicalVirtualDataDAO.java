package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.MemberInstructorDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaveInstructorPhysicalVirtualDataDAO {
    public static String getMemberBranchDetails(String memberID) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch_id FROM register WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        String branchId = null;

        if(resultSet.next()){
            branchId =  resultSet.getString(1);
            return branchId;
        }else {
            return null;
        }
    }

    public static boolean virtualTableInsertData(String member_id,String instructor_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO virtual_member VALUES(?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,member_id);
        pst.setString(2,instructor_id);

        return pst.executeUpdate() > 0;
    }

    public static boolean physicalTableInsertData(String member_id,String instructor_id,String branch_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO physical_member VALUES(?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,member_id);
        pst.setString(2,instructor_id);
        pst.setString(3,branch_id);

        return pst.executeUpdate() > 0;
    }
}
