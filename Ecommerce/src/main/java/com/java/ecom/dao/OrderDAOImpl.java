package com.java.ecom.dao;

import java.util.ArrayList;
import java.util.List;
import com.java.ecom.model.Order;
import com.java.ecom.model.Payment;
import com.java.ecom.util.ConnectionHelper;
import com.java.ecom.dao.OrderDAO;
import com.java.ecom.util.ConnectionHelper;
import com.java.ecom.model.Order;
import com.java.ecom.model.OrderItem;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OrderDAOImpl implements OrderDAO {

    @Override
    public void placeOrder(int customerId, double totalPrice, String shippingAddress) {
        String query = "INSERT INTO orders (customer_id, total_price, shipping_address, order_date) VALUES (?, ?, ?, NOW())";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, customerId);
            statement.setDouble(2, totalPrice);
            statement.setString(3, shippingAddress);
            int affectedRows = statement.executeUpdate();

            if (affectedRows > 0) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int orderId = generatedKeys.getInt(1);
                    System.out.println("Order placed successfully. Order ID: " + orderId);
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOrdersByCustomerId(int customerId) {
        String query = "SELECT * FROM orders WHERE customer_id = ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, customerId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                double totalPrice = resultSet.getDouble("total_price");
                String shippingAddress = resultSet.getString("shipping_address");
                Date orderDate = resultSet.getDate("order_date");

                System.out.println("Order ID: " + orderId + 
                        "\nTotal Price: " + totalPrice +
                        "\nShipping Address: " + shippingAddress + 
                        "\nOrder Date: " + orderDate);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOrdersWithTotalPriceGreaterThan(double price) {
        String query = "SELECT * FROM orders WHERE total_price > ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDouble(1, price);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                int customerId = resultSet.getInt("customer_id");
                double totalPrice = resultSet.getDouble("total_price");
                String shippingAddress = resultSet.getString("shipping_address");
                Date orderDate = resultSet.getDate("order_date");

                System.out.println("Order ID: " + orderId + ", Customer ID: " + customerId + ", Total Price: " + totalPrice +
                        ", Shipping Address: " + shippingAddress + ", Order Date: " + orderDate);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showAllOrderItems() {
        String query = "SELECT oi.*, p.name,p.price FROM order_items oi " +
                       "JOIN products p ON oi.product_id = p.product_id";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderItemId = resultSet.getInt("order_item_id");
                int orderId = resultSet.getInt("order_id");
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");

                System.out.println("Order Item Details:");
                System.out.println("Order Item ID: " + orderItemId +
                                   "\nOrder ID: " + orderId +
                                   "\nProduct ID: " + productId +
                                   "\nProduct Name: " + productName +
                                   "\nQuantity: " + quantity +
                                   "\nPrice: " + price +
                                   "\n------------------");

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOrderItemsByProductId(int productId) {
    	String query = "SELECT oi.*, o.customer_id, p.price FROM order_items oi " +
                "JOIN products p ON oi.product_id = p.product_id " +
                "JOIN orders o ON oi.order_id = o.order_id " +
                "WHERE oi.product_id = ?";

        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, productId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderItemId = resultSet.getInt("order_item_id");
                int orderId = resultSet.getInt("order_id");
                int quantity = resultSet.getInt("quantity");
                double price = resultSet.getDouble("price");
                int customerId = resultSet.getInt("customer_id");

                System.out.println("Order Item Details:");
                System.out.println("Order Item ID: " + orderItemId +
                                   "\nOrder ID: " + orderId +
                                   "\nCustomer ID: " + customerId +
                                   "\nQuantity: " + quantity +
                                   "\nPrice: " + price);

            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showOrdersByDateRange(String startDate, String endDate) {
        String query = "SELECT * FROM orders WHERE order_date BETWEEN ? AND ?";
        try (Connection connection = ConnectionHelper.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, startDate);
            statement.setString(2, endDate);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int orderId = resultSet.getInt("order_id");
                int customerId = resultSet.getInt("customer_id");
                double totalPrice = resultSet.getDouble("total_price");
                String shippingAddress = resultSet.getString("shipping_address");
                Date orderDate = resultSet.getDate("order_date");

                System.out.println("Order ID: " + orderId + ", Customer ID: " + customerId + ", Total Price: " + totalPrice +
                        ", Shipping Address: " + shippingAddress + ", Order Date: " + orderDate);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}   
