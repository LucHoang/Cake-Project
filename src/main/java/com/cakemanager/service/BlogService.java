package com.cakemanager.service;

import com.cakemanager.model.Blog;
import com.cakemanager.model.BlogCategory;
import com.cakemanager.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogService {
    private static final String SELECT_ALL_BLOG_CATE = "select * from blogcategory;";
    private static final String SELECT_ALL_BLOGS = "select * from blogs;";
    private static final String SEARCH_BY_BLOG = "select * from blogs where content like ?;";
    private static final String GET_BLOG_BY_BLOG_CATE_ID = "select * from blogs where blogCateId = ?;";

    public List<BlogCategory> selectAllBlogCate() {
        List<BlogCategory> list = new ArrayList<>();

        try (Connection connection = DatabaseConection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BLOG_CATE)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int blogCateId = rs.getInt("blogCateId");
                String blogCateName = rs.getString("blogCateName");
                list.add(new BlogCategory(blogCateId, blogCateName));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public static void main(String[] args) {
        BlogService blogService = new BlogService();

        List<BlogCategory> blogCategoryList = blogService.selectAllBlogCate();
        for (BlogCategory o: blogCategoryList) {
            System.out.println(o);
        }
    }
    public List<Product> selectAllBlogs() {
        List<Product> list = new ArrayList<>();

        try (Connection connection = DatabaseConection.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL_BLOGS)) {
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

    public List<Product> searchByBlog(String textSearch) {
        List<Product> list = new ArrayList<>();

        try {
            Connection connection = DatabaseConection.getConnection();
            PreparedStatement ps = connection.prepareStatement(SEARCH_BY_BLOG);
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

    public Product getBlogByBlogCateId(String productId) {
        try {
            Connection connection = DatabaseConection.getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_BLOG_BY_BLOG_CATE_ID);
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
}
