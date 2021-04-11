package com.cakemanager.service;

import com.cakemanager.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterService {
    private static final String REGISTER_ACOUNT_SQL = "insert into account(name,phone,email,address,password,roll)value (?,?,?,?,?,false);";

    public void registerAcount(String name,String phone,String email,String address,String password){
        Account account =  null;
        Connection connection = DatabaseConection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_ACOUNT_SQL);
                preparedStatement.setString(1, name);
                preparedStatement.setString(2, phone);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, address);
                preparedStatement.setString(5, password);
                preparedStatement.executeUpdate();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
