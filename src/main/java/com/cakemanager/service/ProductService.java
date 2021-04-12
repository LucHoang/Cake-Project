package com.cakemanager.service;

import com.cakemanager.model.Cart;
import com.cakemanager.model.Category;
import com.cakemanager.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private static final String SELECT_FROM_PRODUCTS_WHERE_PRODUCT_ID = "select * from products where productId =?";
    private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (productName, productPrice, quantity, priceTotal, userId, thumbnail, productId) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT__WHERE_CATEGORY_ID = "select * from products where categoryId =?";
    private static final String SELECT_CATEGORY_NAME_WHERE_PRODUCT_ID = "select category.name from category, products where category.categoryId = products.categoryId and products.productId =?";

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

    public List<Product> selectProductByCategoryId(int id) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DatabaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT__WHERE_CATEGORY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

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
            preparedStatement.setInt(7, cart.getProductId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Category selectCategoryByProductId(int id) {
        Category category = null;
        try (Connection connection = DatabaseConection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_NAME_WHERE_PRODUCT_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                category= new Category(name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return category;
    }
}
