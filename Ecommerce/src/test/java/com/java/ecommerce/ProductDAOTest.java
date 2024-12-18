package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.ProductDAO;
import com.java.ecom.dao.ProductDAOImpl;

public class ProductDAOTest {

    @Test
    public void testAddProduct() {
        ProductDAO productDAO = new ProductDAOImpl();

        // Test data
        String productName = "Smartphone";
        double price = 15000.50;
        String description = "A high-end smartphone with 128GB storage.";
        int stockQuantity = 50;

        // Adding product
        try {
            productDAO.addProduct(productName, price, description, stockQuantity);
            System.out.println("Test Passed: Product added successfully.");
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
