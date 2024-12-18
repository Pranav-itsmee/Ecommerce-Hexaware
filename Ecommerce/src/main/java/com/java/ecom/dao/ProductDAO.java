package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.Product;

public interface ProductDAO {
    void showProducts();
    void searchProductById(int productId);
    void addProduct(String name, double price, String description, int stockQuantity);
    void showTop5ProductsBySales(); 
    void showLowStockProducts();
}

