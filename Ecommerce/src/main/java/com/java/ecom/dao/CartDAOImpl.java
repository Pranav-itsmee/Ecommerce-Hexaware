package com.java.ecom.dao;

import com.java.ecom.util.ConnectionHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CartDAOImpl implements CartDAO {

    @Override
    public void addCart(int customerId, int productId, int quantity) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO cart (customer_id, product_id, quantity) VALUES (?, ?, ?)")) {
            ps.setInt(1, customerId);
            ps.setInt(2, productId);
            ps.setInt(3, quantity);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Product added to cart successfully.");
            } else {
                System.out.println("Failed to add product to cart.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCart(int cartId, int quantity) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE cart SET quantity = ? WHERE cart_id = ?")) {
            ps.setInt(1, quantity);
            ps.setInt(2, cartId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Cart updated successfully.");
            } else {
                System.out.println("Failed to update cart.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void searchCartById(int cartId) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM cart WHERE cart_id = ?")) {
            ps.setInt(1, cartId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Cart ID: " + rs.getInt("cart_id"));
                    System.out.println("Customer ID: " + rs.getInt("customer_id"));
                    System.out.println("Product ID: " + rs.getInt("product_id"));
                    System.out.println("Quantity: " + rs.getInt("quantity"));
                } else {
                    System.out.println("No cart found with ID: " + cartId);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCartById(int cartId) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM cart WHERE cart_id = ?")) {
            ps.setInt(1, cartId);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Cart deleted successfully.");
            } else {
                System.out.println("Failed to delete cart.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showCustomerCart(int customerId) {
        try (Connection conn = ConnectionHelper.getConnection();
             PreparedStatement ps = conn.prepareStatement(
                     "SELECT c.cart_id, p.name AS product_name, c.quantity, p.price " +
                             "FROM cart c JOIN products p ON c.product_id = p.product_id " +
                             "WHERE c.customer_id = ?")) {
            ps.setInt(1, customerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    System.out.println("Cart ID: " + rs.getInt("cart_id"));
                    System.out.println("Product Name: " + rs.getString("product_name"));
                    System.out.println("Quantity: " + rs.getInt("quantity"));
                    System.out.println("Price: " + rs.getDouble("price"));
                    System.out.println("---------------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

