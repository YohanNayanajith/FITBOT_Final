package com.group39.fitbot.group39_fitbot.dao;
import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Notification;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NotificationDAO {
    public static List<Notification> getNotification(String member_id) throws SQLException, ClassNotFoundException {
        List<Notification> notificationList = new ArrayList<>();

        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM notification WHERE user_id=? AND notification_status=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,member_id);
        pst.setInt(2,0);

        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if(resultSet != null) {
                notificationList.add(new Notification(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTime(4).toLocalTime(),
                        resultSet.getDate(5).toLocalDate(),
                        resultSet.getString(6),
                        resultSet.getInt(7)
                ));
            }
        }
        return notificationList;
    }

    public static boolean updateNotificationDetails(int notification_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE notification SET notification_status=? WHERE notification_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,1);
        pst.setInt(2,notification_id);

        System.out.println("Payment added updateMembershipRenewalDetails");

        return pst.executeUpdate() > 0;
    }
}
