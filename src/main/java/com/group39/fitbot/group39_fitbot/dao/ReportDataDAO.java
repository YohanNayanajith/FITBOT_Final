package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Branch;
import com.group39.fitbot.group39_fitbot.model.BranchEquipmentCount;
import com.group39.fitbot.group39_fitbot.model.BranchMemberCount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReportDataDAO {

    public static List<BranchMemberCount> getBranchMemberCount() throws SQLException,ClassNotFoundException {
        List<BranchMemberCount> branchmembercount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(r.member_id) FROM  branch br INNER JOIN register r ON r.branch_id=br.branch_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                branchmembercount.add(new BranchMemberCount(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return branchmembercount;
    }

    public static List<BranchEquipmentCount> getEquipmentCount() throws SQLException,ClassNotFoundException {
        List<BranchEquipmentCount> equipmentcount = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = " SELECT br.branch_name, COUNT(r.member_id) FROM  branch br INNER JOIN register r ON r.branch_id=br.branch_id GROUP BY br.branch_id";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()){
            if(resultSet!=null)
            {
                equipmentcount.add(new BranchEquipmentCount(
                        resultSet.getString(1),
                        resultSet.getInt(2)
                ));

            }
        }
        return equipmentcount;
    }
}
