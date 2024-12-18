package com.java.ecom.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.ecom.model.OrderItem;

public interface OrderItemsDao {
	
	List<OrderItem> showOrderItemsDao() throws ClassNotFoundException, SQLException;
}
