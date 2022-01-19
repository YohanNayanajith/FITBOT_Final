package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Branch;
import com.group39.fitbot.group39_fitbot.model.Workout;


import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintainerBranchSelecterDAO  {
    public static List<Branch> getBranchNameList() throws SQLException, ClassNotFoundException{
        System.out.println("in DAO");
        List<Branch> branch_list = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM branch";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                branch_list.add(new Branch(
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
        System.out.println(branch_list);
        return branch_list;
    }
}
