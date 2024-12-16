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
import com.nt.entity.GroceryProduct;
import com.nt.service.GroceryService;

@RestController
@RequestMapping("/api/grocery")
public class GroceryProductController {

	@Autowired
	private GroceryService groceryService;
	
	    @GetMapping
	    public List<GroceryProduct> getAllGroceryItems() {
	        return groceryService.getAllGroceryProduct();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<GroceryProduct> getGroceryItemById(@PathVariable Long id) {
	        return ResponseEntity.ok(groceryService.getGroceryProductById(id));
	    }

	    @PostMapping
	    public ResponseEntity<GroceryProduct> createGroceryItem(@RequestBody String gproductData) throws JsonMappingException, JsonProcessingException {
	    	GroceryProduct gpdata=new ObjectMapper().readValue(gproductData, GroceryProduct.class);
	    	return ResponseEntity.ok(groceryService.createGroceryProduct(gpdata));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<GroceryProduct> updateGroceryItem(@PathVariable Long id, @RequestBody GroceryProduct groceryItemDetails) {
	        return ResponseEntity.ok(groceryService.updateGroceryItem(id, groceryItemDetails));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteGroceryItem(@PathVariable Long id) {
	        groceryService.deleteGroceryProduct(id);
	        return ResponseEntity.noContent().build();
	    }
}
