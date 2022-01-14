package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerInstructorView;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ManagerInstructorViewDAO {
    public static List<ManagerInstructorView> getManagerInstructorView(String branchID,LocalDate currentDate) throws SQLException,ClassNotFoundException{
        List<ManagerInstructorView> all_instrucotr = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT instructor.first_name,instructor.last_name,\n" +
                "COUNT(DISTINCT member.member_id) AS member_count,\n" +
                "COUNT(DISTINCT appointment.appointment_id) AS appoinment_count\n" +
                "\n" +
                "FROM ((member\n" +
                "INNER JOIN instructor ON member.instructor_id = instructor.instructor_id)\n" +
                "INNER JOIN appointment ON appointment.member_id = member.member_id)\n" +
                "WHERE instructor.branch_id= ? AND appointment.appoinment_date=?\n" +
                "GROUP BY instructor.instructor_id";

        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        pst.setDate(2, Date.valueOf(currentDate));

        System.out.println("****************");
        System.out.println(all_instrucotr);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()){
            if (resultSet != null){
                all_instrucotr.add(new ManagerInstructorView(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4)
                ));
            }
        }
        System.out.println(all_instrucotr);
        return all_instrucotr;
    }
}
