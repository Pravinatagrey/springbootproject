package com.nt.service;

import java.util.List;

import com.nt.entity.Order;

public interface OrderService {
	
		List<Order> getAllOrders();
	    Order getOrderById(Long id);
	    Order createOrder(Order order);
	    Order updateOrder(Long id, Order orderDetails);
	    void deleteOrder(Long id);
}
