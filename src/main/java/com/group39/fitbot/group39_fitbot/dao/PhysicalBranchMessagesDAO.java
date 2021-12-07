package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.PhysicalBranchMessages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhysicalBranchMessagesDAO {
    public static List<PhysicalBranchMessages> getBranchMessagesData() throws SQLException, ClassNotFoundException {
        List<PhysicalBranchMessages> PhysicalBranchMessagesList = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM notice ORDER BY dates DESC";
        PreparedStatement pst = connection.prepareStatement(query);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                PhysicalBranchMessagesList.add(new PhysicalBranchMessages(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getString(4),
                        resultSet.getString(5)
                ));
            }
        }
        return PhysicalBranchMessagesList;
    }
}
