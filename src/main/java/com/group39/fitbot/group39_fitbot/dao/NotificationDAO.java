package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Notification;
import com.group39.fitbot.group39_fitbot.model.Workout;

import java.sql.*;
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

    public static boolean insertNotificationDetails(Notification notification) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "INSERT INTO notification(user_id, notification_title, notification_time, notification_date, notification_type, notification_status) VALUES(?,?,?,?,?,?)";

        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,notification.getUser_id());
        pst.setString(2,notification.getNotification_title());
        pst.setTime(3, Time.valueOf(notification.getNotification_time()));
        pst.setDate(4,Date.valueOf(notification.getNotification_date()));
        pst.setString(5,notification.getNotification_type());
        pst.setInt(6,notification.getNotification_status());

        System.out.println("Payment added updateMembershipRenewalDetails");

        return pst.executeUpdate() > 0;
    }
}
