package com.java.ecom.dao;

import java.sql.*;

import com.java.ecom.util.ConnectionHelper;

public class PaymentDAOImpl implements PaymentDAO {

    @Override
    public void addPayment(int orderId, String paymentMethod, String transactionId, String paymentStatus) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "INSERT INTO payments (order_id, payment_method, transaction_id, payment_status) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderId);
            statement.setString(2, paymentMethod);
            statement.setString(3, transactionId);
            statement.setString(4, paymentStatus);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updatePayment(int paymentId, String paymentStatus) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "UPDATE payments SET payment_status = ? WHERE payment_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, paymentStatus);
            statement.setInt(2, paymentId);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showPendingPayments() {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "SELECT * FROM payments WHERE payment_status = 'Pending'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("Payment ID: " + rs.getInt("payment_id"));
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Payment Method: " + rs.getString("payment_method"));
                System.out.println("Transaction ID: " + rs.getString("transaction_id"));
                System.out.println("Payment Status: " + rs.getString("payment_status"));
                System.out.println("---------");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showCompletedPayments() {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "SELECT * FROM payments WHERE payment_status = 'Completed'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("Payment ID: " + rs.getInt("payment_id"));
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Payment Method: " + rs.getString("payment_method"));
                System.out.println("Transaction ID: " + rs.getString("transaction_id"));
                System.out.println("Payment Status: " + rs.getString("payment_status"));
                System.out.println("---------");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showPaymentDetailsByOrderId(int orderId) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "SELECT * FROM payments WHERE order_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, orderId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Payment ID: " + rs.getInt("payment_id"));
                System.out.println("Payment Method: " + rs.getString("payment_method"));
                System.out.println("Transaction ID: " + rs.getString("transaction_id"));
                System.out.println("Payment Status: " + rs.getString("payment_status"));
            } else {
                System.out.println("No payment found for Order ID: " + orderId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void showPaymentById(int paymentId) {
        try (Connection connection = ConnectionHelper.getConnection()) {
            String query = "SELECT * FROM payments WHERE payment_id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, paymentId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Payment Method: " + rs.getString("payment_method"));
                System.out.println("Transaction ID: " + rs.getString("transaction_id"));
                System.out.println("Payment Status: " + rs.getString("payment_status"));
            } else {
                System.out.println("No payment found with Payment ID: " + paymentId);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
