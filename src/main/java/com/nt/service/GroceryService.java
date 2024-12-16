package com.nt.service;

import java.util.List;

import com.nt.entity.GroceryProduct;

public interface GroceryService {
	  public List<GroceryProduct> getAllGroceryProduct();
	  public GroceryProduct getGroceryProductById(Long id);
	  public GroceryProduct createGroceryProduct(GroceryProduct groceryProduct);
	  public GroceryProduct updateGroceryProduct(Long id, GroceryProduct groceryDetails);
	  public GroceryProduct updateGroceryItem(Long id, GroceryProduct groceryDetails);
	  public void deleteGroceryProduct(Long id) ;
	  
}
