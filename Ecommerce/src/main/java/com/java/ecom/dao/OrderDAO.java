package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.ecom.model.Order;
import com.java.ecom.model.Payment;

public interface OrderDAO {
    void placeOrder(int customerId, double totalPrice, String shippingAddress);
    void showOrdersByCustomerId(int customerId);
    void showOrdersWithTotalPriceGreaterThan(double price);
    void showAllOrderItems();
    void showOrderItemsByProductId(int productId);
    void showOrdersByDateRange(String startDate, String endDate);
}


