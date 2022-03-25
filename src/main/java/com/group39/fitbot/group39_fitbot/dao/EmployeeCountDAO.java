package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Employee;
import com.group39.fitbot.group39_fitbot.model.EmployeeCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCountDAO {

        public static EmployeeCount getEmployeeCount() throws SQLException, ClassNotFoundException{
            EmployeeCount employeecount = new EmployeeCount();
            Connection connection = DBConnection.getInstance().getConnection();
            String query = "SELECT\n" +
                    "\t( SELECT count(*) FROM maintainer m INNER JOIN users u ON m.maintainer_id=u.member_id where u.status =1 ) AS column1,\n" +
                    "\t( SELECT count(*) FROM instructor i INNER JOIN users u ON i.instructor_id=u.member_id where u.status =1 ) AS column2,\n" +
                    "\t( SELECT count(*) FROM branch_manager br INNER JOIN users u ON br.branchmanager_id=u.member_id where u.status =1 ) AS column3";
            PreparedStatement pst = connection.prepareStatement(query);

            ResultSet resultSet = pst.executeQuery();


                if(resultSet.next()) {
                    employeecount.setMaintainer_count(resultSet.getInt(1));
                    employeecount.setInstructor_count(resultSet.getInt(2));
                    employeecount.setBranch_manager_count(resultSet.getInt(3));
                }

            return employeecount;
        }

        public static int getBranchManagerCount() throws SQLException, ClassNotFoundException {
            int branchmanagercount = 0;
            Connection connection =DBConnection.getInstance().getConnection();
            String query= "SELECT Count(*) FROM branch_manager";
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet resultSet = pst.executeQuery();

            if(resultSet.next()) {
                if (resultSet != null) {
                    branchmanagercount = resultSet.getInt(1);
                    System.out.println(branchmanagercount);
                }

            }

            return branchmanagercount;
        }

    public static int getInstructorCount() throws SQLException, ClassNotFoundException {
        int instructorcount = 0;
        Connection connection =DBConnection.getInstance().getConnection();
        String query= "SELECT Count(*) FROM instructor";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();

        if(resultSet.next()) {
            if (resultSet != null) {
                instructorcount = resultSet.getInt(1);
                System.out.println(instructorcount);
            }

        }

        return instructorcount;
    }

    public static int getMaintainerCount() throws SQLException, ClassNotFoundException {
        int maintainercount = 0;
        Connection connection =DBConnection.getInstance().getConnection();
        String query= "SELECT Count(*) FROM maintainer";
        PreparedStatement pst = connection.prepareStatement(query);
        ResultSet resultSet = pst.executeQuery();

        if(resultSet.next()) {
            if (resultSet != null) {
                maintainercount = resultSet.getInt(1);
                System.out.println(maintainercount);
            }

        }

        return maintainercount;
    }
}




