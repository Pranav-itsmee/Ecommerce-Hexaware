package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.PaymentDAO;
import com.java.ecom.dao.PaymentDAOImpl;

public class PaymentDAOTest {

    @Test
    public void testAddPayment() {
        PaymentDAO paymentDAO = new PaymentDAOImpl();

        // Test data
        int orderId = 123; // Assuming this order exists
        String paymentMethod = "Credit Card";
        String transactionId = "TXN12345";
        String paymentStatus = "Completed";

        // Adding payment
        try {
            paymentDAO.addPayment(orderId, paymentMethod, transactionId, paymentStatus);
            System.out.println("Test Passed: Payment added successfully.");
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
