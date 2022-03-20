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
        String query = " SELECT br.branch_name, COUNT(CASE WHEN u.status = '1' then 1 ELSE NULL END) as \"UnBan\", COUNT(CASE WHEN u.status = '0' then 1 ELSE NULL END) as \"Ban\" FROM  branch br INNER JOIN register r ON r.branch_id=br.branch_id INNER JOIN users u ON u.member_id=r.member_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                branchmembercount.add(new BranchMemberCount(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));

            }
        }
        return branchmembercount;
    }

    public static List<BranchEquipmentCount> getEquipmentCount() throws SQLException,ClassNotFoundException {
        List<BranchEquipmentCount> equipmentcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT br.branch_name , count(e.equipment_id) FROM branch br INNER JOIN equipment e ON e.branch_id=br.branch_id GROUP BY br.branch_id";
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
        String query = "SELECT CONVERT(MONTHNAME(joined_date),char(3)) as Month, count(member_id) FROM register GROUP BY CONCAT(MONTH(joined_date),YEAR(joined_date)) ORDER BY joined_date ";
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

    public static List<EmployeeTypeCount> getIncomeMemberType() throws SQLException,ClassNotFoundException {
        List<EmployeeTypeCount> incomemembertype = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(p.payment_date), SUM(CASE WHEN r.membership_sign =\"physical_member\" then p.payment_amount else 0 END),SUM(CASE WHEN r.membership_sign =\"virtual_member\" then p.payment_amount else 0 END) FROM online_payment p INNER JOIN payment_paidmember_membership pp ON p.alter_table_payment_id=pp.payment_id INNER JOIN register r ON r.member_id =pp.member_id GROUP BY CONCAT(MONTH(p.payment_date),YEAR(p.payment_date))";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                incomemembertype .add(new EmployeeTypeCount(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));

            }
        }
        return incomemembertype;
    }
}
