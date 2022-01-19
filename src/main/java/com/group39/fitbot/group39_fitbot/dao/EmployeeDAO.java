package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Employee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    // Function to retrieve all employees
    public static List<Employee> getEmployee() throws SQLException, ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query= "SELECT b.branchmanager_id, br.branch_name, b.first_name, b.last_name, b.gender, b.email, b.nic, b.dob, b.address, b.primary_contact, b.secondary_contact, b.joined_date,\"Branch Manager\" as type FROM branch_manager b INNER JOIN branch br ON br.branch_id=b.branch_id INNER JOIN users u ON u.member_id=b.branchmanager_id where u.`status`=1 UNION SELECT i.instructor_id, br.branch_name, i.first_name, i.last_name, i.gender, i.email, i.nic, i.dob, i.address, i.primary_contact, i.secondary_contact, i.joined_date, \"Instructor\" as type FROM instructor i INNER JOIN branch br ON br.branch_id=i.branch_id INNER JOIN users u ON u.member_id=i.instructor_id where u.`status`=1";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();
        System.out.println(resultSet);

        while (resultSet.next()) {
            if(resultSet != null) {
                employees.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getDate(12).toLocalDate(),
                        resultSet.getString(13)

                ));

            }
        }
        String query1= "SELECT m.maintainer_id, m.first_name, m.last_name, m.gender, m.email, m.nic, m.dob, m.address, m.primary_contact, m.secondary_contact, m.joined_date, \"Maintainer\" as type FROM maintainer m INNER JOIN users u ON u.member_id=m.maintainer_id where u.`status`=1 ";
        PreparedStatement pst1 = connection.prepareStatement(query1);

        ResultSet resultSet1 = pst1.executeQuery();
        String maintainer_branch ="-";
        while (resultSet1.next()) {
            if(resultSet1 != null) {
                employees.add(new Employee(
                        resultSet1.getString(1),
                        maintainer_branch,
                        resultSet1.getString(2),
                        resultSet1.getString(3),
                        resultSet1.getString(4),
                        resultSet1.getString(5),
                        resultSet1.getString(6),
                        resultSet1.getString(7),
                        resultSet1.getString(8),
                        resultSet1.getString(9),
                        resultSet1.getString(10),
                        resultSet1.getDate(11).toLocalDate(),
                        resultSet1.getString(12)


                ));

            }
        }

        return employees;
    }

    //Function to retrive intructors relevant to each branch
    public static List<Employee> getInstructor(String branchid) throws SQLException, ClassNotFoundException{
        List<Employee> instructors = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " Select * FROM instructor where branch_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchid);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                instructors.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getDate(12).toLocalDate()



                ));

            }
        }
        return instructors;
    }

    //Function to retrieve branchmanagers relevant to each branch
    public static List<Employee> getBranchManager(String branchid) throws SQLException, ClassNotFoundException{
        List<Employee> branch_managers = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " Select * FROM branch_manager where branch_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchid);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                branch_managers.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getDate(12).toLocalDate()



                ));

            }
        }
        return branch_managers;
    }

    //Remove Instructor
    public static boolean removeinstructor(String employee_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET status=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,0);
        pst.setString(2,employee_id);

        System.out.println("Instructor Removed Successfully");

        return pst.executeUpdate() > 0;
    }

    //Remove Instructor
    public static boolean removemaintainer(String employee_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET status=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,0);
        pst.setString(2,employee_id);

        System.out.println("Maintainer Removed Successfully");

        return pst.executeUpdate() > 0;
    }

    //Remove BranchManager
    public static boolean removebranchmanager(String employee_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET status=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,0);
        pst.setString(2,employee_id);
        System.out.println(employee_id);
        System.out.println("Branch Manager Removed Successfully");

        return pst.executeUpdate() > 0;
    }

    public static List<Employee> getInstructor() throws SQLException, ClassNotFoundException{
        List<Employee> instructors = new ArrayList<>();
//
        Connection connection = DBConnection.getInstance().getConnection();
        String query1= "SELECT i.instructor_id, br.branch_name, i.first_name, i.last_name, i.gender, i.email, i.nic, i.dob, i.address, i.primary_contact, i.secondary_contact, i.joined_date, \"Instructor\" as type FROM instructor i INNER JOIN branch br ON br.branch_id=i.branch_id INNER JOIN users u ON u.member_id=i.instructor_id where u.`status`=1";
        PreparedStatement pst = connection.prepareStatement(query1);

        ResultSet resultSet = pst.executeQuery();
        System.out.println(resultSet);

        while (resultSet.next()) {
            if(resultSet != null) {
                instructors.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getDate(12).toLocalDate(),
                        resultSet.getString(13)


                ));

            }
        }
        return instructors;
    }

    public static List<Employee> getBranchManager() throws SQLException, ClassNotFoundException{
        List<Employee> branch_managers = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT b.branchmanager_id, br.branch_name, b.first_name, b.last_name, b.gender, b.email, b.nic, b.dob, b.address, b.primary_contact, b.secondary_contact, b.joined_date,\"Branch Manager\" as type FROM branch_manager b INNER JOIN branch br ON br.branch_id=b.branch_id INNER JOIN users u ON u.member_id=b.branchmanager_id where u.`status`=1";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                branch_managers.add(new Employee(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getDate(12).toLocalDate(),
                        resultSet.getString(13)



                ));

            }
        }
        return branch_managers;
    }

    public static List<Employee> getMaintainers() throws SQLException, ClassNotFoundException{
        List<Employee> maintainers = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT m.maintainer_id, m.first_name, m.last_name, m.gender, m.email, m.nic, m.dob, m.address, m.primary_contact, m.secondary_contact, m.joined_date, \"Maintainer\" as type FROM maintainer m INNER JOIN users u ON u.member_id=m.maintainer_id where u.`status`=1";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        String maintainer_branch ="-";
        while (resultSet.next()) {
            if(resultSet != null) {
                maintainers.add(new Employee(
                        resultSet.getString(1),
                        maintainer_branch,
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10),
                        resultSet.getDate(11).toLocalDate(),
                        resultSet.getString(12)



                ));

            }
        }
        return maintainers;
    }


}


