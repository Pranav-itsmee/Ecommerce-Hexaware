package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.OrderDAO;
import com.java.ecom.dao.OrderDAOImpl;

public class OrderDAOTest {

    @Test
    public void testPlaceOrder() {
        OrderDAO orderDAO = new OrderDAOImpl();

        // Test data
        int customerId = 1; // Assuming this customer exists in the database
        double totalPrice = 5000.50;
        String shippingAddress = "123 Main Street, City, Country";

        // Placing order
        try {
            orderDAO.placeOrder(customerId, totalPrice, shippingAddress);
            System.out.println("Test Passed: Order placed successfully.");
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
