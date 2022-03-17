package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDataDAO {

    public static List<BranchMemberCount> getBranchMemberCount() throws SQLException,ClassNotFoundException {
        List<BranchMemberCount> branchmembercount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(r.member_id) FROM  branch br INNER JOIN register r ON r.branch_id=br.branch_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                branchmembercount.add(new BranchMemberCount(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return branchmembercount;
    }

    public static List<BranchEquipmentCount> getEquipmentCount() throws SQLException,ClassNotFoundException {
        List<BranchEquipmentCount> equipmentcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(r.member_id) FROM  branch br INNER JOIN register r ON r.branch_id=br.branch_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                equipmentcount.add(new BranchEquipmentCount(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return equipmentcount;
    }

    public static List<MemberRegisterCount> getMemberRegisterCount() throws SQLException,ClassNotFoundException {
        List<MemberRegisterCount> memberregistercount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(joined_date), count(member_id) FROM register GROUP BY CONCAT(MONTH(joined_date),YEAR(joined_date)) ORDER BY joined_date ";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                memberregistercount.add(new MemberRegisterCount(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return memberregistercount;
    }

    public static List<EmployeeTypeCount> getEmployeeTypeCount() throws SQLException,ClassNotFoundException {
        List<EmployeeTypeCount> employeetypecount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(i.instructor_id), COUNT(b.branchmanager_id) FROM branch br INNER JOIN instructor i ON i.branch_id=br.branch_id INNER JOIN branch_manager b ON b.branch_id= br.branch_id GROUP BY br.branch_name";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                employeetypecount.add(new EmployeeTypeCount(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));

            }
        }
        return employeetypecount;
    }
}
