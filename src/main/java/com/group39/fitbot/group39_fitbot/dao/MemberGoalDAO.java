package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.MemberGoal;
import com.group39.fitbot.group39_fitbot.model.Membership;

import java.sql.*;

public class MemberGoalDAO {

    public static boolean insertMemberGoalDetailsWeight(MemberGoal memberGoal) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO member_goal(member_id,weight_goal) VALUES(?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,memberGoal.getMember_id());
        pst.setDouble(2,memberGoal.getWeight_goal());

        return pst.executeUpdate() > 0;
    }

    public static boolean insertMemberGoalDetailsCalory(MemberGoal memberGoal) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO member_goal(member_id,calory_goal) VALUES(?,?)";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setString(1,memberGoal.getMember_id());
        pst.setDouble(2,memberGoal.getCalory_goal());

        return pst.executeUpdate() > 0;
    }

    public static boolean updateMemberGoalDetailsWeight(MemberGoal memberGoal) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE member_goal SET weight_goal=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setDouble(1,memberGoal.getWeight_goal());
        pst.setString(2,memberGoal.getMember_id());

        return pst.executeUpdate() > 0;
    }

    public static boolean updateMemberGoalDetailsCalory(MemberGoal memberGoal) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE member_goal SET calory_goal=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);

        pst.setDouble(1,memberGoal.getCalory_goal());
        pst.setString(2,memberGoal.getMember_id());

        return pst.executeUpdate() > 0;
    }

    public static MemberGoal selectMemberGoalDetails(String memberID) throws SQLException, ClassNotFoundException{
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT * FROM member_goal WHERE member_id = ?";

        PreparedStatement pst = connection.prepareStatement(query);

        MemberGoal memberGoal = new MemberGoal();

        pst.setString(1,memberID);

        ResultSet resultSet = pst.executeQuery();

        if(resultSet.next()){
            memberGoal.setMember_id(resultSet.getString(1));
            memberGoal.setWeight_goal(resultSet.getDouble(2));
            memberGoal.setCalory_goal(resultSet.getDouble(3));

            return memberGoal;
        }else {
            return null;
        }
    }
}
