package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface CustomerService {

	List<Customer> findAllCustomer();
	Customer createCustomer(Customer c);
	Customer customerfindById(Long id);
	void deleteCustomerById(Long id);
	Customer updateCustomer(Long id, Customer customerDetails);
	
}
