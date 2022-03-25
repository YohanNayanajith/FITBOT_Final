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

    public static List<XY> getEquipmentCount() throws SQLException,ClassNotFoundException {
        List<XY> equipmentcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT br.branch_name , count(e.equipment_id) FROM branch br INNER JOIN equipment e ON e.branch_id=br.branch_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                equipmentcount.add(new XY(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return equipmentcount;
    }

    public static List<XY> getMemberRegisterCount() throws SQLException,ClassNotFoundException {
        List<XY> memberregistercount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT CONVERT(MONTHNAME(joined_date),char(3)) as Month, count(member_id) FROM register GROUP BY CONCAT(MONTH(joined_date),YEAR(joined_date)) ORDER BY joined_date ";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                memberregistercount.add(new XY(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return memberregistercount;
    }

    public static List<XYY> getEmployeeTypeCount() throws SQLException,ClassNotFoundException {
        List<XYY> employeetypecount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(DISTINCT i.instructor_id), COUNT(DISTINCT b.branchmanager_id) FROM branch br INNER JOIN instructor i ON i.branch_id=br.branch_id INNER JOIN branch_manager b ON b.branch_id= br.branch_id GROUP BY br.branch_name";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                employeetypecount.add(new XYY(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));

            }
        }
        return employeetypecount;
    }

    public static List<XYY> getIncomeMemberType() throws SQLException,ClassNotFoundException {
        List<XYY> incomemembertype = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(p.payment_date), SUM(CASE WHEN r.membership_sign =\"physical_member\" then p.payment_amount else 0 END),SUM(CASE WHEN r.membership_sign =\"virtual_member\" then p.payment_amount else 0 END) FROM online_payment p INNER JOIN payment_paidmember_membership pp ON p.alter_table_payment_id=pp.payment_id INNER JOIN register r ON r.member_id =pp.member_id GROUP BY CONCAT(MONTH(p.payment_date),YEAR(p.payment_date))ORDER BY p.payment_date";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                incomemembertype .add(new XYY(
                        resultSet.getString(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3)
                ));

            }
        }
        return incomemembertype;
    }

    public static List<XY> getBranchIncome(String branch_id) throws SQLException,ClassNotFoundException {
        List<XY> branchincome = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(p.payment_date), SUM(p.payment_amount)FROM online_payment p INNER JOIN payment_paidmember_membership pp ON p.alter_table_payment_id=pp.payment_id INNER JOIN register r ON r.member_id =pp.member_id WHERE r.branch_id =? GROUP BY CONCAT(MONTH(p.payment_date),YEAR(p.payment_date)) ORDER BY p.payment_date ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branch_id);
        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                branchincome.add(new XY(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return branchincome;
    }

    public static List<XY> getVirtualIncome() throws SQLException,ClassNotFoundException {
        List<XY> virtualincome = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(p.payment_date), SUM(p.payment_amount)FROM online_payment p INNER JOIN payment_paidmember_membership pp ON p.alter_table_payment_id=pp.payment_id INNER JOIN register r ON r.member_id =pp.member_id WHERE r.membership_sign =\"virtual_member\" GROUP BY CONCAT(MONTH(p.payment_date),YEAR(p.payment_date)) ORDER BY p.payment_date ";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                virtualincome.add(new XY(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return virtualincome;
    }

    public static List<XY> getIncomeTotal() throws SQLException,ClassNotFoundException {
        List<XY> totalincome = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT MONTHNAME(p.payment_date),SUM(p.payment_amount) FROM online_payment p INNER JOIN payment_paidmember_membership pp ON p.alter_table_payment_id=pp.payment_id INNER JOIN register r ON r.member_id =pp.member_id GROUP BY CONCAT(MONTH(p.payment_date),YEAR(p.payment_date))ORDER BY p.payment_date";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                totalincome .add(new XY(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return totalincome;
    }
}
