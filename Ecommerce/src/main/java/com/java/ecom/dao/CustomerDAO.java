package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.Customer;

public interface CustomerDAO {
    void showCustomers();
    void searchCustomerById(int customerId);
    void searchCustomerByUsername(String username);
    boolean authenticateCustomer(String email, String password);
    void addCustomer(String firstName, String lastName, String email, String password, String gender);
    void showCustomersWithMostOrders();
}
