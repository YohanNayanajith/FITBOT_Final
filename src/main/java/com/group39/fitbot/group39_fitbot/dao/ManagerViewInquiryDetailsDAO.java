package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerViewInquiry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerViewInquiryDetailsDAO {
    public static List<ManagerViewInquiry> getManagerViewInquiryDetails(String managerId, String branchID,String inquiryID) throws SQLException, ClassNotFoundException{
        List<ManagerViewInquiry> inquiries = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT\n" +
                "member.first_name,\n" +
                "make_inquiry.inquiry_id,\n" +
                "make_inquiry.inquiry_date,\n" +
                "make_inquiry.inquiry_time,\n" +
                "make_inquiry.status,\n" +
                "make_inquiry.inquiry_title, \n" +
                "make_inquiry.description \n" +
                "FROM ((member\n" +
                "INNER JOIN make_inquiry ON member.member_id=make_inquiry.member_id)\n" +
                "INNER JOIN branch_manager ON branch_manager.branchmanager_id = make_inquiry.branchmanager_id)\n" +
                "WHERE branch_manager.branch_id=? AND make_inquiry.inquiry_id=?";

//        String inquiry_id = inquiryID ;
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println("shalaniiiiiiiiiiiiii");
        System.out.println(managerId);
        pst.setString(1,branchID);
        pst.setString(2,inquiryID);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()){
            if (resultSet != null){
                inquiries.add(new ManagerViewInquiry(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getDate(3),
                        resultSet.getTime(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7)
                ));
            }
        }
        System.out.println("is inquiry work");
        System.out.println(inquiries);
        return inquiries;
    }
}
