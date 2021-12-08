package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.PhysicalPayment;
import com.group39.fitbot.group39_fitbot.model.Registartion;
import com.group39.fitbot.group39_fitbot.model.UpdateWeight;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditProfileDAO {
    public static boolean updateMemberDetails(Registartion registartion) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE register SET first_name=?,last_name=?,dob=?,phone_number=?,height=?,weight=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,registartion.getFirst_name());
        pst.setString(2,registartion.getLast_name());
        pst.setDate(3, Date.valueOf(registartion.getDate_of_birth()));
        pst.setInt(4,registartion.getContact_number());
        pst.setInt(5,registartion.getHeight());
        pst.setInt(6,registartion.getWeight());
        pst.setString(7,registartion.getMember_id());

        System.out.println("Edit profile DAO");
        return pst.executeUpdate() > 0;
    }

    public static boolean updateLoginDetails(Registartion registartion) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE users SET user_name=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,registartion.getFirst_name());
        pst.setString(2,registartion.getMember_id());

//        System.out.println("Edit profile  DAO");
        return pst.executeUpdate() > 0;
    }

    public static Registartion retriveRegistration(String member_id) throws SQLException, ClassNotFoundException {
        Registartion register = new Registartion();

        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT first_name,last_name,dob,phone_number,height,weight FROM register WHERE member_id= ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
//        pst.setString(3,login.getUserType());

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()) {
            register.setFirst_name(resultSet.getString(1));
            register.setLast_name(resultSet.getString(2));
            register.setDate_of_birth((resultSet.getDate(3)).toLocalDate());
            register.setContact_number(resultSet.getInt(4));
            register.setHeight(resultSet.getInt(5));
            register.setWeight(resultSet.getInt(6));
            return register;
        } else {
            return null;
        }
    }

    public static boolean updateWeightDetails(UpdateWeight updateWeight) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "INSERT INTO weight_update(member_id,update_date,daily_count,previous_weight,new_weight) VALUES(?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,updateWeight.getMember_id());
        pst.setDate(2,Date.valueOf(updateWeight.getUpdate_date()));
        pst.setInt(3,updateWeight.getDaily_count());
        pst.setDouble(4,updateWeight.getPrevious_weight());
        pst.setDouble(5,updateWeight.getNew_weight());

        return pst.executeUpdate() > 0;
    }

    public static List<UpdateWeight> retriveUpdateWeight(String member_id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();

        String query = "SELECT * FROM weight_update WHERE member_id= ? ORDER BY update_date DESC";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, member_id);
//        pst.setString(3,login.getUserType());
        List<UpdateWeight> updateWeightList = new ArrayList<>();

        ResultSet resultSet = pst.executeQuery();

        while(resultSet.next()) {
            if (resultSet != null) {
                updateWeightList.add(
                      new  UpdateWeight(
                              resultSet.getInt(1),
                              resultSet.getString(2),
                              resultSet.getDate(3).toLocalDate(),
                              resultSet.getInt(4),
                              resultSet.getDouble(5),
                              resultSet.getDouble(6)
                      )
                );
            }
        }
        return updateWeightList;
    }

    public static boolean updateRegisterWeight(String member_id, double weight) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "UPDATE register SET weight=? WHERE member_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setDouble(1,weight);
        pst.setString(2,member_id);

        return pst.executeUpdate() > 0;
    }
}
