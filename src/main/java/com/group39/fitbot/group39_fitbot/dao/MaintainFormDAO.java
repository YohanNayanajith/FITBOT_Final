package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.FormMaintain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintainFormDAO {
    public static List<FormMaintain> getFormMaintain(String memberID) throws SQLException, ClassNotFoundException{
        List<FormMaintain> forms = new ArrayList<>();
        FormMaintain formMaintain=new FormMaintain();
        Connection connection = DBConnection.getInstance().getConnection();
        String query="SELECT * FROM form WHERE maintainer_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1, memberID);

        ResultSet resultSet = pst.executeQuery();
        System.out.println("DAO method called in new");

        while(resultSet.next()){
            if(resultSet !=null){
                forms.add(new FormMaintain(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getTime(9),
                        resultSet.getDate(10),
                        resultSet.getString(11),
                        resultSet.getString(12),
                        resultSet.getDate(13),
                        resultSet.getTime(14)
                ));
            }
        }
        System.out.println(forms);
        return forms;
    }


}
