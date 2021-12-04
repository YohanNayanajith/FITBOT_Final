package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.PhysicalAppointment;
import com.group39.fitbot.group39_fitbot.model.Workout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhysicalAppointmentDAO {
    public static boolean addAppointmentDetails(PhysicalAppointment physicalAppointment) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO appointment(start_time,finish_time,equipment,member_id,appointment_date) VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setTime(1, Time.valueOf(physicalAppointment.getStart_time()));
        pst.setTime(2, Time.valueOf(physicalAppointment.getFinish_time()));
        pst.setString(3,physicalAppointment.getEquipment());
        pst.setString(4,physicalAppointment.getMember_id());
        pst.setDate(5, Date.valueOf(physicalAppointment.getAppointment_date()));

        return pst.executeUpdate() > 0;
    }

    public static List<PhysicalAppointment> getAppoitmentData(String memberID) throws SQLException, ClassNotFoundException {
        List<PhysicalAppointment> physicalAppointmentList = new ArrayList<>();
//        PhysicalAppointment physicalAppointment = new PhysicalAppointment();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM appointment WHERE member_id=? ORDER BY appointment_date DESC";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                physicalAppointmentList.add(new PhysicalAppointment(
                        resultSet.getDate(6).toLocalDate(),
                        resultSet.getTime(2).toLocalTime(),
                        resultSet.getTime(3).toLocalTime(),
                        resultSet.getString(4),
                        resultSet.getString(5)

                ));
            }
        }
        return physicalAppointmentList;
    }
}
