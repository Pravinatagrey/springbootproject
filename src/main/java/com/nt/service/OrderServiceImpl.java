package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Order;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orepo;
	
	@Override
	public List<Order> getAllOrders() {
		return orepo.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		return orepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Order not found with ID: "+id));
	}

	@Override
	public Order createOrder(Order order) {
		return orepo.save(order);
	}

	@Override
	public Order updateOrder(Long id, Order orderDetails) {
		  Order order = orepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));

		  order.setCustomer(orderDetails.getCustomer());
		  order.setGroceryItems(orderDetails.getGroceryItems());
		  order.setOrderDate(orderDetails.getOrderDate());
		  order.setTotalPrice(orderDetails.getTotalPrice());

	        return orepo.save(order);
	}

	@Override
	public void deleteOrder(Long id) {
		  Order order = orepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Order not found with ID: " + id));
		  orepo.delete(order);
	}

}
