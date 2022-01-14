package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Notice;
import com.group39.fitbot.group39_fitbot.model.NoticeBranchMnagaer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NoticeDAO {

    public NoticeDAO() {
    }

    public static boolean addNotice(NoticeBranchMnagaer noticeBranchMnagaer) throws SQLException, ClassNotFoundException{

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO notice (title,dates,description,branchmanager_id) VALUES (?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
//        pst.setInt(1,notice.getNotice_no());
        pst.setString(1,noticeBranchMnagaer.getTitle());
        pst.setDate(2, noticeBranchMnagaer.getDates());
        pst.setString(3,noticeBranchMnagaer.getDescription());
        pst.setString(4,noticeBranchMnagaer.getBranchmanager_id());

        return pst.executeUpdate() > 0;

    }
}
