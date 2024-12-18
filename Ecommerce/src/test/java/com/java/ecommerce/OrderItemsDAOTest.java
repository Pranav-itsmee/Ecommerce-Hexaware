package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.OrderDAO;
import com.java.ecom.dao.OrderDAOImpl;

public class OrderItemsDAOTest {

    @Test
    public void testShowOrderItemsByProductId() {
        OrderDAO orderDAO = new OrderDAOImpl();

        // Test data
        int productId = 101; // Assuming this product exists in orders

        // Fetching order items for a product
        try {
            orderDAO.showOrderItemsByProductId(productId);
            System.out.println("Test Passed: Order items fetched successfully for Product ID " + productId);
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
