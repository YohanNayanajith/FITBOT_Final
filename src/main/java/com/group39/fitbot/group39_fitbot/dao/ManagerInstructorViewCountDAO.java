package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerInstructorViewCount;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerInstructorViewCountDAO {
    public static List<ManagerInstructorViewCount> getManagerInstructorViewCount(String branchID, LocalDate currentDate) throws SQLException, ClassNotFoundException {
        List<ManagerInstructorViewCount> all_view_count = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT \n" +
                "(SELECT COUNT(instructor_attendance.instructor_id) AS ins_attendence\n" +
                "FROM (instructor\n" +
                "INNER JOIN instructor_attendance ON instructor.instructor_id = instructor_attendance.instructor_id)\n" +
                "WHERE instructor.branch_id = ? AND instructor_attendance.date = ? ),\n" +
                "(SELECT COUNT(instructor.instructor_id) AS ins_total\n" +
                "FROM instructor\n" +
                "WHERE instructor.branch_id = ?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, branchID);
        pst.setDate(2, Date.valueOf(currentDate));
        pst.setString(3, branchID);

        System.out.println("****************");
        System.out.println(all_view_count);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                all_view_count.add(new ManagerInstructorViewCount(
                        resultSet.getInt(1),
                        resultSet.getInt(2)
                ));
            }
        }
        System.out.println(all_view_count);
        return all_view_count;
    }
}