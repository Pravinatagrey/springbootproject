package com.nt.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="orders")
public class Order {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "customer_id")
	    private Customer customer;


	    @ManyToMany
	    @JoinTable(
	            name = "order_grocery_product",
	            joinColumns = @JoinColumn(name = "order_id"),
	            inverseJoinColumns = @JoinColumn(name = "grocery_product_id")
	    )
	    private Set<GroceryProduct> groceryItems;
	    private Date orderDate;
	    private double totalPrice;

}
