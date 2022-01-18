package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
//import com.group39.fitbot.group39_fitbot.model.AddNotice;
import com.group39.fitbot.group39_fitbot.model.Notice;
//import com.group39.fitbot.group39_fitbot.model.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddNoticeDAO {
    public static List<Notice> getNotice(String branchID) throws SQLException, ClassNotFoundException{
        List<Notice> notices = new ArrayList<>();
        Notice notice = new Notice();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT notice.title,notice.dates,notice.description,branch_manager.branch_id\n" +
                "FROM (notice \n" +
                "INNER JOIN branch_manager ON notice.branchmanager_id=branch_manager.branchmanager_id)\n" +
                "WHERE branch_manager.branch_id=?\n" +
                "ORDER BY notice_no DESC";
        PreparedStatement pst = connection.prepareStatement(query);
        System.out.println(branchID);
        pst.setString(1, branchID);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                notices.add(new Notice(
                        resultSet.getString(1),
                        resultSet.getDate(2),
                        resultSet.getString(3)
                ));
            }
        }

        return notices;

    }

}
