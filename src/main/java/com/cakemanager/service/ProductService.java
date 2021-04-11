package com.cakemanager.service;

import com.cakemanager.model.Cart;
import com.cakemanager.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductService {
    private static final String SELECT_FROM_PRODUCTS_WHERE_PRODUCT_ID = "select * from products where productId =?";
    private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (productName, productPrice, quantity, priceTotal, userId, thumbnail) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

    public ProductService() {

    }

    public Product selectProductById(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FROM_PRODUCTS_WHERE_PRODUCT_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int categoryId = rs.getInt("categoryId");
                product = new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, categoryId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    private void printSQLException(SQLException e) {
    }

    public void insertCart(Cart cart) throws SQLException {
        System.out.println(INSERT_CART_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DatabaseConection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
            preparedStatement.setString(1, cart.getProductName());
            preparedStatement.setFloat(2, cart.getProductPrice());
            preparedStatement.setInt(3, cart.getQuantity());
            preparedStatement.setFloat(4, cart.getPriceTotal());
            preparedStatement.setInt(5, cart.getUserId());
            preparedStatement.setString(6, cart.getThumbnail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
