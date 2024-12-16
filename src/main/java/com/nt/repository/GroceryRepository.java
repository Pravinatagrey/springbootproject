package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.GroceryProduct;

public interface GroceryRepository extends JpaRepository<GroceryProduct, Long> {

}
