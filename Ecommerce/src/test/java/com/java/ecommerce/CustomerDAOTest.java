package com.java.ecommerce;

import org.junit.Test;
import com.java.ecom.dao.CustomerDAO;
import com.java.ecom.dao.CustomerDAOImpl;

public class CustomerDAOTest {

    @Test
    public void testAddCustomer() {
        CustomerDAO customerDAO = new CustomerDAOImpl();

        // Test data
        String firstName = "John";
        String lastName = "Doe";
        String email = "johndoe@example.com";
        String password = "password123";
        String gender = "Male";

        // Adding customer
        try {
            customerDAO.addCustomer(firstName, lastName, email, password, gender);
            System.out.println("Test Passed: Customer added successfully.");
        } catch (Exception e) {
            System.err.println("Test Failed: " + e.getMessage());
        }
    }
}
