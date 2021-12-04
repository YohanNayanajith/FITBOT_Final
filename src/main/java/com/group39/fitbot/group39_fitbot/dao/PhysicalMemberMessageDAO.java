package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.PhysicalMemberMessage;
import com.group39.fitbot.group39_fitbot.model.Registartion;
import com.group39.fitbot.group39_fitbot.model.Workout;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhysicalMemberMessageDAO {
    private static int getChatData(String instructor_id, String member_id) throws SQLException, ClassNotFoundException {
        String query = "SELECT chat_id FROM chat WHERE sender_id= ? AND receiver_id = ?";
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
        pst.setString(2, instructor_id);

        ResultSet resultSet = pst.executeQuery();

        int chatID = 0;
        if (resultSet.next()) {
            chatID = resultSet.getInt(1);
        }

        return chatID;
    }

    public static List<PhysicalMemberMessage> retriveMessageDetailsSenderMember(String instructor_id, String member_id) throws SQLException, ClassNotFoundException {
        PhysicalMemberMessage messages = new PhysicalMemberMessage();

        Connection connection = DBConnection.getInstance().getConnection();

        int chatID = getChatData(instructor_id, member_id);

        List<PhysicalMemberMessage> physicalMemberMessage = new ArrayList<>();

        if(chatID != 0){
            String query1 = "SELECT * FROM message WHERE chat_id= ? ORDER BY message_time ASC";
            PreparedStatement pst1 = connection.prepareStatement(query1);
            pst1.setInt(1, chatID);

            ResultSet resultSet1 = pst1.executeQuery();

            while(resultSet1.next()) {
                if (resultSet1 != null) {
                    physicalMemberMessage.add(new PhysicalMemberMessage(
                            resultSet1.getInt(1),
                            resultSet1.getInt(2),
                            resultSet1.getDate(3).toLocalDate(),
                            resultSet1.getTime(4).toLocalTime(),
                            resultSet1.getString(6),
                            resultSet1.getInt(5)
                    ));
                }
            }
        }

        return physicalMemberMessage;
    }

    public static boolean insertMessageDetails(String member_id,String globalInstructorID, PhysicalMemberMessage physicalMemberMessage) throws SQLException, ClassNotFoundException {

        int chatID = getChatData(globalInstructorID, member_id);

        if(chatID == 0){
            boolean b = insertMessageDetails(member_id, globalInstructorID);
            if(!b){
                return false;
            }
        }
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO message(message_status,message_date,message_time,chat_id,message_description) VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setInt(1,physicalMemberMessage.getMessage_status());
        pst.setDate(2, Date.valueOf(physicalMemberMessage.getMessage_date()));
        pst.setTime(3,Time.valueOf(physicalMemberMessage.getMessage_time()));
        pst.setInt(4,chatID);
        pst.setString(5,physicalMemberMessage.getMessage_description());
        return pst.executeUpdate() > 0;
    }

    public static boolean insertMessageDetails(String member_id,String instructor_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO chat(sender_id,receiver_id,chat_status) VALUES(?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,member_id);
        pst.setString(2,instructor_id);
        pst.setString(3,"Online");

        return pst.executeUpdate() > 0;
    }
}
