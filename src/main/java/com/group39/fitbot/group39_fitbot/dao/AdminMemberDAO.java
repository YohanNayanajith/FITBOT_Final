package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.AdminMember;
import com.group39.fitbot.group39_fitbot.model.BannedMember;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.Login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminMemberDAO {
    // Retrieve All Members
    public static List<AdminMember> getMember() throws SQLException, ClassNotFoundException {
        List<AdminMember> members = new ArrayList<>();
//
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender, b.branch_name ,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN branch b ON b.branch_id =r.branch_id INNER JOIN users u ON u.member_id=r.member_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id  where u.status=\"1\"";
        PreparedStatement pst = connection.prepareStatement(query);
        String physicaltype = "Physical";

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                members.add(new AdminMember(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getDate(9).toLocalDate(),
                        physicaltype
                ));

            }
        }
        String query1 = "SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN users u ON u.member_id=r.member_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id  where u.status=\"1\" AND r.membership_sign=\"virtual_member\" ";
        PreparedStatement pst1 = connection.prepareStatement(query1);
        String virtualtype = "Virtual";
        String branch = "-";

        ResultSet resultSet1 = pst1.executeQuery();

        while (resultSet1.next()) {
            if (resultSet1 != null) {
                members.add(new AdminMember(
                        resultSet1.getString(1),
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5),
                        branch,
                        resultSet1.getString(6),
                        resultSet1.getString(7),
                        resultSet1.getDate(8).toLocalDate(),
                        virtualtype
                ));

            }
        }
        return members;
    }

    public static List<AdminMember> getPhysicalMember() throws SQLException, ClassNotFoundException {
        List<AdminMember> physicalmembers = new ArrayList<>();
//
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender, b.branch_name ,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN branch b ON b.branch_id =r.branch_id INNER JOIN users u ON u.member_id=r.member_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id  where u.status=\"1\"";
        PreparedStatement pst = connection.prepareStatement(query);
        String physicaltype = "Physical";

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                physicalmembers.add(new AdminMember(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getDate(9).toLocalDate(),
                        physicaltype
                ));
            }

        }
        return physicalmembers;
    }

    public static List<AdminMember> getBannedMembers() throws SQLException, ClassNotFoundException {
        List<AdminMember> members = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender, b.branch_name ,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN branch b ON b.branch_id =r.branch_id INNER JOIN users u ON u.member_id=r.member_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id  where u.status=\"0\"";
        PreparedStatement pst = connection.prepareStatement(query);
        String physicaltype = "Physical";

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                members.add(new AdminMember(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getDate(9).toLocalDate(),
                        physicaltype
                ));

            }
        }
        String query1 = "SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN users u ON u.member_id=r.member_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id  where u.status=\"0\" AND r.membership_sign=\"virtual_member\" ";
        PreparedStatement pst1 = connection.prepareStatement(query1);
        String virtualtype = "Virtual";
        String branch = "-";

        ResultSet resultSet1 = pst1.executeQuery();

        while (resultSet1.next()) {
            if (resultSet1 != null) {
                members.add(new AdminMember(
                        resultSet1.getString(1),
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5),
                        branch,
                        resultSet1.getString(6),
                        resultSet1.getString(7),
                        resultSet1.getDate(8).toLocalDate(),
                        virtualtype
                ));

            }
        }
        return members;
    }

    public static boolean addBanMember (BannedMember BannedMember) throws SQLException, ClassNotFoundException{
        Connection connection= DBConnection.getInstance().getConnection();
        String query = "INSERT INTO banned_members VALUES (?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1, BannedMember.getMember_id());
        pst.setString(2, BannedMember.getBanned_reason());
        pst.setDate(3, Date.valueOf(BannedMember.getBanned_date()));
        return pst.executeUpdate()>0;
    }

    public static AdminMember retrievePhysicalMember (String memberid) throws SQLException, ClassNotFoundException{
        AdminMember physical_member = new AdminMember();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender, b.branch_name ,r.membership_category,r.email, m.expiry_date  From register r INNER JOIN branch b ON b.branch_id =r.branch_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id where r.member_id =?";
        PreparedStatement pst = connection.prepareStatement(query);
        String physicaltype = "Physical";

        pst.setString(1,memberid);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            physical_member.setMember_id(resultSet.getString(1));
            physical_member.setFirst_name(resultSet.getString(2));
            physical_member.setLast_name(resultSet.getString(3));
            physical_member.setContact_no(resultSet.getString(4));
            physical_member.setGender(resultSet.getString(5));
            physical_member.setBranch_name(resultSet.getString(6));
            physical_member.setMembership(resultSet.getString(7));
            physical_member.setEmail(resultSet.getString(8));
            physical_member.setDue_date(resultSet.getDate(9).toLocalDate());
            physical_member.setType(physicaltype);


            }

        System.out.println(physical_member);
        return physical_member;
        }

    public static AdminMember retrieveVirtualMember (String memberid) throws SQLException, ClassNotFoundException{
        AdminMember virtual_member = new AdminMember();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender,r.membership_category,r.email, m.expiry_date  From register r  INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id where r.member_id =?";
        PreparedStatement pst = connection.prepareStatement(query);
        String virtualtype = "Virtual";
        String branch = "-";

        pst.setString(1,memberid);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            virtual_member.setMember_id(resultSet.getString(1));
            virtual_member.setFirst_name(resultSet.getString(2));
            virtual_member.setLast_name(resultSet.getString(3));
            virtual_member.setContact_no(resultSet.getString(4));
            virtual_member.setGender(resultSet.getString(5));
            virtual_member.setBranch_name(branch);
            virtual_member.setMembership(resultSet.getString(6));
            virtual_member.setEmail(resultSet.getString(7));
            virtual_member.setDue_date(resultSet.getDate(8).toLocalDate());
            virtual_member.setType(virtualtype);


        }

        return virtual_member;
    }

    public static BannedMember retrievePhysicalBanMember (String memberid) throws SQLException, ClassNotFoundException{
        BannedMember physical_member = new BannedMember();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender, b.branch_name ,r.membership_category,r.email, m.expiry_date ,ba.reason, ba.date From register r INNER JOIN branch b ON b.branch_id =r.branch_id INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id INNER JOIN banned_members ba ON ba.member_id = r.member_id where r.member_id =?";
        PreparedStatement pst = connection.prepareStatement(query);
        String physicaltype = "Physical";

        pst.setString(1,memberid);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            physical_member.setMember_id(resultSet.getString(1));
            physical_member.setFirst_name(resultSet.getString(2));
            physical_member.setLast_name(resultSet.getString(3));
            physical_member.setContact_no(resultSet.getString(4));
            physical_member.setGender(resultSet.getString(5));
            physical_member.setBranch_name(resultSet.getString(6));
            physical_member.setMembership(resultSet.getString(7));
            physical_member.setEmail(resultSet.getString(8));
            physical_member.setDue_date(resultSet.getDate(9).toLocalDate());
            physical_member.setType(physicaltype);
            physical_member.setBanned_reason(resultSet.getString(10));
            physical_member.setBanned_date(resultSet.getDate(11).toLocalDate());

        }

        return physical_member;
    }

    public static BannedMember retrieveVirtualBanMember (String memberid) throws SQLException, ClassNotFoundException{
        BannedMember virtual_member = new BannedMember();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT r.member_id,r.first_name, r.last_name,r.phone_number,r.gender,r.membership_category,r.email, m.expiry_date ,ba.reason, ba.date From register r  INNER JOIN payment_paidmember_membership pm ON pm.member_id = r.member_id INNER JOIN membership m ON m.membership_id = pm.membership_id INNER JOIN banned_members ba ON ba.member_id = r.member_id where r.member_id =?";
        PreparedStatement pst = connection.prepareStatement(query);
        String virtualtype = "Virtual";
        String branch = "-";

        pst.setString(1,memberid);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            virtual_member.setMember_id(resultSet.getString(1));
            virtual_member.setFirst_name(resultSet.getString(2));
            virtual_member.setLast_name(resultSet.getString(3));
            virtual_member.setContact_no(resultSet.getString(4));
            virtual_member.setGender(resultSet.getString(5));
            virtual_member.setBranch_name(branch);
            virtual_member.setMembership(resultSet.getString(6));
            virtual_member.setEmail(resultSet.getString(7));
            virtual_member.setDue_date(resultSet.getDate(8).toLocalDate());
            virtual_member.setType(virtualtype);
            virtual_member.setBanned_reason(resultSet.getString(9));
            virtual_member.setBanned_date(resultSet.getDate(10).toLocalDate());


        }

        return virtual_member;
    }
}

