package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Customer;
import com.nt.service.CustomerService;
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	    @Autowired
	    private CustomerService customerService;

	    @GetMapping
	    public List<Customer> getAllCustomers() {
	        return customerService.findAllCustomer();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
	        return ResponseEntity.ok(customerService.customerfindById(id));
	    }

	    @PostMapping
	    public ResponseEntity<Customer> createCustomer(@RequestBody String customer) throws JsonMappingException, JsonProcessingException {
	    	Customer user=new ObjectMapper().readValue(customer,Customer.class);
	        return ResponseEntity.ok(customerService.createCustomer(user));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails) {
	        return ResponseEntity.ok(customerService.updateCustomer(id, customerDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	        customerService.deleteCustomerById(id);
	        return ResponseEntity.noContent().build();
	    }
}
