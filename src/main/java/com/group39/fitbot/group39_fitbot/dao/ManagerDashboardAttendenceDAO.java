package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboardAttendence;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerDashboardAttendenceDAO {

    public static List<ManagerDashboardAttendence> getManagerDashboardAttendence(String branchID, LocalDate firstdate,LocalDate lastdate,LocalDate fullDate) throws SQLException, ClassNotFoundException {
        List<ManagerDashboardAttendence> new_attendence = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT\n" +
                "(SELECT SUM(cash_payment.payment_amount)\n" +
                "FROM (cash_payment\n" +
                "INNER JOIN  branch_manager ON branch_manager.branchmanager_id = cash_payment.branchmanager_id)\n" +
                "WHERE branch_manager.branch_id = ? AND \n" +
                "cash_payment.payment_date >= ? AND cash_payment.payment_date <= ?),\n" +
                "\n" +
                "(SELECT COUNT(instructor_attendance.instructor_id)\n" +
                "FROM (instructor_attendance\n" +
                "INNER JOIN instructor ON instructor.instructor_id = instructor_attendance.instructor_id)\n" +
                "WHERE instructor.branch_id = ? AND instructor_attendance.date=?),\n" +
                "\n" +
                "(SELECT COUNT(physical_member.member_id) \n" +
                "FROM (member_attendance\n" +
                "INNER JOIN physical_member ON physical_member.member_id = member_attendance.member_id)\n" +
                "WHERE physical_member.branch_id = ? AND member_attendance.date= ? ),\n" +
                "\n" +
                "(SELECT COUNT(appointment.appointment_id)\n" +
                "FROM ((appointment\n" +
                "INNER JOIN member ON appointment.member_id = member.member_id)\n" +
                "INNER JOIN branch ON branch.branch_id = member.branch_id)\n" +
                "WHERE branch.branch_id = ? AND appointment.appoinment_date = ? ),\n" +
                "\n" +
                "\n" +
                "(SELECT COUNT(physical_member.member_id)\n" +
                "FROM physical_member\n" +
                "WHERE physical_member.branch_id=? AND physical_member.joined_date >= ? AND physical_member.joined_date <= ?);";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, branchID);
        pst.setDate(2, Date.valueOf(firstdate));
        pst.setDate(3, Date.valueOf(lastdate));
        pst.setString(4, branchID);
        pst.setDate(5, Date.valueOf(fullDate));
        pst.setString(6, branchID);
        pst.setDate(7, Date.valueOf(fullDate));
        pst.setString(8, branchID);
        pst.setDate(9, Date.valueOf(fullDate));
        pst.setString(10, branchID);
        pst.setDate(11, Date.valueOf(fullDate));
        pst.setDate(12, Date.valueOf(fullDate));
        System.out.println(branchID);
        System.out.println("attendence print");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                new_attendence.add(new ManagerDashboardAttendence(
                        resultSet.getInt(1),
                        resultSet.getInt(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
        }
        System.out.println(new_attendence);
        return new_attendence;
    }
}