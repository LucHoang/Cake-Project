package com.cakemanager.service;

import com.cakemanager.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IndexService implements IIndexService {

    //private static final String INSERT_USERS_SQL = "INSERT INTO products" + "  (name, email, country) VALUES " + " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from products where id =?";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where categoryId =?";
    private static final String SELECT_ALL_USERS = "select * from products";
    private static final String SELECT_CATEGORY_NAME = "select category.name from category join products on category.categoryId = products.categoryId where productId = ?";
    private static final String DELETE_USERS_SQL = "delete from products where id = ?;";
    private static final String UPDATE_USERS_SQL = "update products set name = ?,email= ?, country =? where id = ?;";

    public IndexService() {

    }



    @Override
    public void insertUser(Product product) throws SQLException {

    }

    @Override
    public List<Product> selectUser(int id) {
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConection.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
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
                products.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, categoryId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public List<Product> selectAllUsers() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Product> products = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DatabaseConection.getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);)
        {
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
                products.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, categoryId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return products;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(Product product) throws SQLException {
        return false;
    }

    @Override
    public Product getUserById(int id) {
        return null;
    }

    private void printSQLException(SQLException e) {
    }

}
