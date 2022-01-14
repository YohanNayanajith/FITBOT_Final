package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAttendence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerDashboardAttendenceDAO {

    public static List<ManagerDashboardAttendence> getManagerDashboardAttendence(String branchID) throws SQLException, ClassNotFoundException {
        List<ManagerDashboardAttendence> new_attendence = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT\n" +
                "(SELECT SUM(membership.membership_fee)\n" +
                "FROM ((paid_member\n" +
                "INNER JOIN payment_paidmember_membership ON paid_member.member_id=payment_paidmember_membership.member_id)\n" +
                "INNER JOIN membership ON membership.membership_id =  payment_paidmember_membership.membership_id)\n" +
                "WHERE paid_member.branch_id = ? ),\n" +
                "\n" +
                "(SELECT COUNT(instructor_attendance.instructor_id)\n" +
                "FROM (instructor_attendance\n" +
                "INNER JOIN instructor ON instructor.instructor_id = instructor_attendance.instructor_id)\n" +
                "WHERE instructor.branch_id = ? ),\n" +
                "\n" +
                "(SELECT COUNT(member_attendance.member_id) \n" +
                "FROM (member_attendance\n" +
                "INNER JOIN member ON member.member_id = member_attendance.member_id)\n" +
                "WHERE member.branch_id = ? ),\n" +
                "\n" +
                "(SELECT COUNT(appointment.appointment_id)\n" +
                "FROM ((appointment\n" +
                "INNER JOIN member ON appointment.member_id = member.member_id)\n" +
                "INNER JOIN branch ON branch.branch_id = member.branch_id)\n" +
                "WHERE branch.branch_id = ? )";

//        Date currentdate = fulldate;
//        System.out.println(currentdate);
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, branchID);
        pst.setString(2, branchID);
        pst.setString(3, branchID);
        pst.setString(4, branchID);
        System.out.println(branchID);
        System.out.println("attendence print");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                new_attendence.add(new ManagerDashboardAttendence(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                ));
            }
        }
        System.out.println(new_attendence);
        return new_attendence;
    }
}