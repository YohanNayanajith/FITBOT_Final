package com.group39.fitbot.group39_fitbot.dao;

import com.group39.fitbot.group39_fitbot.database.DBConnection;
import com.group39.fitbot.group39_fitbot.model.ManagerPayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerPaymentDAO {
    public static List<ManagerPayment> getManagerPayment(String branchID) throws SQLException, ClassNotFoundException{
        List<ManagerPayment> payments = new ArrayList<>();
        Connection connection = DBConnection.getInstance().getConnection();
        String query = "SELECT paid_member.first_name,paid_member.last_name,((membership_fee+instructor_price)* (100 - discount_price)/100) AS payment, membership.membership_category \n" +
                "FROM ((paid_member\n" +
                "INNER JOIN payment_paidmember_membership ON payment_paidmember_membership.member_id=paid_member.member_id)\n" +
                "INNER JOIN membership ON membership.membership_id = payment_paidmember_membership.membership_id)\n" +
                "WHERE paid_member.branch_id=?";
        PreparedStatement pst = connection.prepareStatement(query);
        pst.setString(1,branchID);
        System.out.println("****************");
        System.out.println(payments);
        ResultSet resultSet = pst.executeQuery();

        while (resultSet.next()) {
            if (resultSet != null) {
                payments.add(new ManagerPayment(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getInt(3),
                        resultSet.getString(4)
                ));
            }
        }
            System.out.println(payments);
            return payments;
    }
}
