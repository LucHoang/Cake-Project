package com.cakemanager.service;

import com.cakemanager.model.Cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {
    private static final String SELECT_FROM_CART_WHERE_USER_ID = "select * from cart where userId =?";

    public CheckoutService() {

    }

    public List<Cart> selectCart(int id) {
        List<Cart> carts = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_CART_WHERE_USER_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int cartId = rs.getInt("cartId");
                String productName = rs.getString("productName");
                Float productPrice = rs.getFloat("priceTotal");
                int quantity = rs.getInt("quantity");
                Float priceTotal = rs.getFloat("priceTotal");
                String thumbnail = rs.getString("thumbnail");
                int userId = rs.getInt("userId");
                carts.add(new Cart(cartId, productName, productPrice, quantity, priceTotal, thumbnail, userId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        System.out.println(carts);
        return carts;
    }

    private void printSQLException(SQLException e) {
    }
}
