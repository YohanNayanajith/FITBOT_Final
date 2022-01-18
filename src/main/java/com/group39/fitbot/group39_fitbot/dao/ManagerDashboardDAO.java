package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerDashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerDashboardDAO {
    public static List<ManagerDashboard> getManagerDashboard(String branchmanager_id) throws SQLException, ClassNotFoundException {
        List<ManagerDashboard> man_dashboard = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch_manager.first_name,branch_manager.last_name,\n" +
                "COUNT(DISTINCT equipment.equipment_id) AS equipmentcount,\n" +
                "COUNT(DISTINCT instructor.instructor_id) AS instrucotrcount,\n" +
                "COUNT(DISTINCT paid_member.member_id) AS branchmembercount\n" +
                "\n" +
                "FROM (((branch_manager\n" +
                "INNER JOIN equipment ON branch_manager.branch_id = equipment.branch_id)\n" +
                "INNER JOIN instructor ON branch_manager.branch_id=instructor.branch_id)\n" +
                "INNER JOIN paid_member ON branch_manager.branch_id=paid_member.branch_id )\n" +
                "\n" +
                "WHERE branch_manager.branchmanager_id= ?";

        PreparedStatement pst = connection.prepareStatement(query);
//        pst.setString(1, branchID);
        pst.setString(1, branchmanager_id);
        System.out.println("****************");
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                man_dashboard.add(new ManagerDashboard(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5)
                ));
            }
        }
        System.out.println(man_dashboard);
        return man_dashboard;
    }




}

