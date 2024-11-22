package com.java.ecom.dao;

public interface CartDAO {
    
    void addCart(int customerId, int productId, int quantity);
    void updateCart(int cartId, int quantity);
    void searchCartById(int cartId);
    void deleteCartById(int cartId);
    void showCustomerCart(int customerId);
}

