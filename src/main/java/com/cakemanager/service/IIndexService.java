package com.cakemanager.service;

import com.cakemanager.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IIndexService {
     void insertUser(Product product) throws SQLException;

     List<Product> selectUser(int id);

     List<Product> selectAllUsers();

     boolean deleteUser(int id) throws SQLException;

     boolean updateUser(Product product) throws SQLException;

     Product getUserById(int id);


}
