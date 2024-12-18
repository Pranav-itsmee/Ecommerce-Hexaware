package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.CartDAO;
import com.java.ecom.dao.CartDAOImpl;

public class CartDAOTest {

    @Test
    public void testAddCart() {
        CartDAO cartDAO = new CartDAOImpl();

        // Test data
        int customerId = 1; // Assuming this customer exists
        int productId = 101; // Assuming this product exists
        int quantity = 2;

        // Adding cart item
        try {
            cartDAO.addCart(customerId, productId, quantity);
            System.out.println("Test Passed: Cart item added successfully.");
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
