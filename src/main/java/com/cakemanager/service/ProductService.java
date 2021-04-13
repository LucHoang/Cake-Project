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

import static com.cakemanager.service.DatabaseConection.getConnection;

public class ProductService {
    private static final String SELECT_FROM_PRODUCTS_WHERE_PRODUCT_ID = "select * from products where productId =?";
    private static final String INSERT_CART_SQL = "INSERT INTO cart" + "  (productName, productPrice, quantity, priceTotal, userId, thumbnail) VALUES " +
            " (?, ?, ?, ?, ?, ?);";
    private static final String SELECT__WHERE_CATEGORY_ID = "select * from products where categoryId =?";
    private static final String SELECT_CATEGORY_NAME_WHERE_PRODUCT_ID = "select category.name from category, products where category.categoryId = products.categoryId and products.productId =?";
    private static final String GET_PRODUCT_BY_CATE_ID = "select * from products where categoryId = ?;";
    private static final String SELECT_ALL_CATEGORY = "select * from category;";
    private static final String SELECT_ALL_PRODUCTS = "select * from products;";
    private static final String SEARCH_BY_NAME = "select * from products where name like ?;";
    private static final String GET_PRODUCT_BY_PRODUCT_ID = "select * from products where productId = ?;";
    private static final String SORT_PRODUCTS_BY_PRICE_FROM_H2L = "select * from products order by unitPrice desc;";
    private static final String SORT_PRODUCTS_BY_PRICE_FROM_L2H = "select * from products order by unitPrice asc;";


    public ProductService() {

    }

    public Product selectProductById(int id) {
        Product product = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
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
        try (Connection connection = getConnection();
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
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CART_SQL)) {
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

    public Category selectCategoryByProductId(int id) {
        Category category = null;
        try (Connection connection = getConnection();
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

    public List<Product> getAllProductByCateId(String categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_BY_CATE_ID);
            ps.setString(1, categoryId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                list.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, cId));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Category> selectAllCategory() {
        List<Category> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_CATEGORY)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int categoryId = rs.getInt("categoryId");
                String name = rs.getString("name");

                list.add(new Category(categoryId, name));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> selectAllProducts() {
        List<Product> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                list.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, cId));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> searchByName(String textSearch) {
        List<Product> list = new ArrayList<>();

        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(SEARCH_BY_NAME);
            ps.setString(1, "%" + textSearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                list.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, cId));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Product getProductByCateId(String productId) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_PRODUCT_BY_PRODUCT_ID);
            ps.setString(1, productId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int pId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                return new Product(pId, name, unitPrice, quantityStock, productDescription, thumbnail, cId);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Product> sortProductsByPriceFromHtoL() {
        List<Product> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SORT_PRODUCTS_BY_PRICE_FROM_H2L)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                list.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, cId));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Product> sortProductsByPriceFromLtoH() {
        List<Product> list = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SORT_PRODUCTS_BY_PRICE_FROM_L2H)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String name = rs.getString("name");
                Float unitPrice = rs.getFloat("unitPrice");
                int quantityStock = rs.getInt("quantityStock");
                String productDescription = rs.getString("productDescription");
                String thumbnail = rs.getString("thumbnail");
                int cId = rs.getInt("categoryId");

                list.add(new Product(productId, name, unitPrice, quantityStock, productDescription, thumbnail, cId));
            }
        } catch (Exception e) {
        }
        return list;
    }

}
