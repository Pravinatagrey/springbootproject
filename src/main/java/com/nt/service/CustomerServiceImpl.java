package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository crepo;
	
	@Override
	public List<Customer> findAllCustomer() {
		return crepo.findAll();
	}

	@Override
	public Customer createCustomer(Customer c) {
	Customer cust=null;
	cust=crepo.save(c);
		return cust;
	}

	@Override
	public Customer customerfindById(Long id) {
		Optional<Customer> c=Optional.of(crepo.findById(id). orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id)));;
		return c.get();
	}

	@Override
	public void deleteCustomerById(Long id) {
		 Customer user = crepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
		crepo.delete(user);
	}

	@Override
	public Customer updateCustomer(Long id, Customer customerDetails) {
		 Customer user = crepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with ID: " + id));
		 user.setName(customerDetails.getName());
		 user.setEmail(customerDetails.getEmail());
		 user.setAddress(customerDetails.getAddress());
		 user.setPhone(customerDetails.getPhone());

	        return crepo.save(user);
	}
	

}
