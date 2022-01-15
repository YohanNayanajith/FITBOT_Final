package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InsAppointment;
import com.group39.fitbot.group39_fitbot.model.InsStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InstructorAppointmentDAO {

    public static List<InsAppointment> getAppointment(String InsId) throws SQLException, ClassNotFoundException{
        System.out.println("in student appointment");
        System.out.println(InsId);

        List<InsAppointment> all_appointment = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT member.first_name , appointment.appointment_date , appointment.start_time , appointment.finish_time FROM appointment , member WHERE appointment.member_id=member.member_id AND appointment.instructor_id=? ";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, InsId);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                all_appointment.add(new InsAppointment(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getTime(3),
                        resultSet.getTime(4)
                ));
            }
        }


        return all_appointment;
    }
}
