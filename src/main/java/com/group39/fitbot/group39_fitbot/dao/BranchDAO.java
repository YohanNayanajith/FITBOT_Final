package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Branch;
import com.group39.fitbot.group39_fitbot.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BranchDAO {
    public static List<Branch> getBranch() throws SQLException ,ClassNotFoundException {
        List<Branch> branches = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT * FROM BRANCH";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                branches.add(new Branch(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                        ));

            }
        }
        return branches;
    }

    public static Branch getBranchdetails(String branchname) throws SQLException ,ClassNotFoundException {
        Branch branch = new Branch();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT * FROM BRANCH where branch_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,branchname);
        ResultSet resultSet = pst.executeQuery();


        if (resultSet.next()){
            {
                        branch.setBranch_id(resultSet.getString(1));
                        branch.setBranch_name(resultSet.getString(2));
                        branch.setBranch_address(resultSet.getString(3));
                        branch.setBranch_email(resultSet.getString(4));
                        branch.setBranch_date_of_commencement(resultSet.getDate(5).toLocalDate());
                        branch.setBranch_primary_contact(resultSet.getString(6));
                        branch.setBranch_secondary_contact(resultSet.getString(7));

            }
        }
        return branch;
    }

    public static boolean AddBranch (Branch branch) throws SQLException, ClassNotFoundException {
        Connection connection= DBConnection.getInstance().getConnection();
        String query = "INSERT INTO branch VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,branch.getBranch_id());
        pst.setString(2, branch.getBranch_name());
        pst.setString(3, branch.getBranch_address());
        pst.setString(4, branch.getBranch_email());
        pst.setDate(5, Date.valueOf(branch.getBranch_date_of_commencement()));
        pst.setString(6, branch.getBranch_primary_contact());
        pst.setString(7, branch.getBranch_secondary_contact());
        pst.setString(8, branch.getBranch_image());

        return pst.executeUpdate()>0;
    }
}
