package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.InsLeave;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class InstructorLeaveSubmitDAO {
    public static boolean submitLeaveForm(InsLeave leaveForme) throws SQLException, ClassNotFoundException {
        Connection connection  =DBConnection.getInstance().getConnection();
        String query ="INSERT INTO instructor_leave VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1, leaveForme.getInstructor_id());
        pst.setDate(2, (Date) leaveForme.getRequest_date());
        pst.setString(3, leaveForme.getBranch_id());
        pst.setString(4, leaveForme.getLeave_reason());
        pst.setDate(5, (Date) leaveForme.getLeave_form_date());
        pst.setTime(6, leaveForme.getLeave_form_time());
        pst.setDate(7, (Date) leaveForme.getLeave_to_date());
        pst.setTime(8, leaveForme.getLeave_to_time());

        System.out.println("done");
        return pst.executeUpdate()>0;
    }
}
