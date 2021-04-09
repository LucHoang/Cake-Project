package com.cakemanager.service;

import com.cakemanager.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginService {
    private static final String CHECK_USER_PASSWORD_SQL = "select * from account where userName = ? and password = ?";

    public boolean checkLogin(String userName,String password){
        Connection connection = DatabaseConection.getConnection();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(CHECK_USER_PASSWORD_SQL);
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2,password);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    return true;
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
}
