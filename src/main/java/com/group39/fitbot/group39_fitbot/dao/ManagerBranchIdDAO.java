package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerBranchIdDAO {
    public static Manager getManager(String managerID) throws SQLException, ClassNotFoundException {
//        List<Manager> branchManager = new ArrayList<>();
        Manager branchManager_r = new Manager();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT branch_id,branchmanager_id FROM branch_manager WHERE branchmanager_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,managerID);
        ResultSet resultSet = pst.executeQuery();

        System.out.println("manager branchid");
        System.out.println(branchManager_r);
        System.out.println(managerID);

        if (resultSet.next()) {
            branchManager_r.setBranch_id(resultSet.getString(1));
            branchManager_r.setBranchmanager_id(resultSet.getString(2));
        }

        System.out.println("is branchid work");
        System.out.println(branchManager_r);
        return branchManager_r;
    }
}
