package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.Login;
import com.group39.fitbot.group39_fitbot.model.Maintainer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaintainerDAO {

    public static Maintainer getMaintainer(String memberID) throws SQLException, ClassNotFoundException {
//        System.out.println("In maintainerDAO");
        Maintainer maintainer = new Maintainer();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT maintainer_id,first_name,last_name,email FROM maintainer WHERE maintainer_id = ?";
        PreparedStatement pst = connection.prepareStatement(query);
//      pst.setString(1, login.getMember_id);
        pst.setString(1, memberID);

        ResultSet resultSet = pst.executeQuery();

        if (resultSet.next()){
            maintainer.setMaintainer_id(resultSet.getString(1));
            maintainer.setFirst_name(resultSet.getString(2));
            maintainer.setLast_name(resultSet.getString(3));
            maintainer.setEmail(resultSet.getString(4));

        }

//        System.out.println(maintainer);
        return maintainer;
    }


}
