package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long Id;
	
	private String name;
	private String email;
	private String address;
	private String phone;
	
}
