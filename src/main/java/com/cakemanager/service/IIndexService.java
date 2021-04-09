package com.cakemanager.service;

import com.cakemanager.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IIndexService {
    public void insertUser(Product product) throws SQLException;

    public Product selectUser(int id);

    public List<Product> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(Product product) throws SQLException;

    public Product getUserById(int id);
}
