package com.java.ecom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ecom.model.Product;
import com.java.ecom.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void showProducts() {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM products");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Price: " + rs.getDouble("price"));
                System.out.println("Description: " + rs.getString("description"));
                System.out.println("Stock Quantity: " + rs.getInt("stockQuantity"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchProductById(int productId) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM products WHERE product_id = ?")) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Product ID: " + rs.getInt("product_id"));
                    System.out.println("Name: " + rs.getString("name"));
                    System.out.println("Price: " + rs.getDouble("price"));
                    System.out.println("Description: " + rs.getString("description"));
                    System.out.println("Stock Quantity: " + rs.getInt("stockQuantity"));
                } else {
                    System.out.println("No product found with ID: " + productId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addProduct(String name, double price, String description, int stockQuantity) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO products (name, price, description, stockQuantity) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, name);
            ps.setDouble(2, price);
            ps.setString(3, description);
            ps.setInt(4, stockQuantity);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product added successfully.");
            } else {
                System.out.println("Failed to add product.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showTop5ProductsBySales() {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT p.product_id, p.name, SUM(oi.quantity) AS total_sold " +
                             "FROM products p " +
                             "JOIN order_items oi ON p.product_id = oi.product_id " +
                             "GROUP BY p.product_id " +
                             "ORDER BY total_sold DESC LIMIT 5");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Total Sold: " + rs.getInt("total_sold"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showLowStockProducts() {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT product_id, name, stockQuantity " +
                             "FROM products WHERE stockQuantity < 10");
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println("Product ID: " + rs.getInt("product_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Stock Quantity: " + rs.getInt("stockQuantity"));
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
