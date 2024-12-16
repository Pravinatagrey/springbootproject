package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.GroceryProduct;
import com.nt.exception.ResourceNotFoundException;
import com.nt.repository.GroceryRepository;

@Service
public class GroceryServiceImpl implements GroceryService {

	@Autowired
	private GroceryRepository grepo;
	

	@Override
	public GroceryProduct getGroceryProductById(Long id){
		GroceryProduct gp=null;
		gp = grepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Grocery not found : "+id));
		return gp;
	}

	@Override
	public GroceryProduct createGroceryProduct(GroceryProduct groceryProduct) {
		return grepo.save(groceryProduct);
	}

	@Override
	public GroceryProduct updateGroceryProduct(Long id, GroceryProduct groceryDetails) {
		GroceryProduct item = grepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Grocery Product not found with ID: " + id));

		item.setName(groceryDetails.getName());
		item.setCategory(groceryDetails.getCategory());
		item.setPrice(groceryDetails.getPrice());
		item.setQuantity(groceryDetails.getQuantity());

	        return grepo.save(item);
	}

	@Override
	public void deleteGroceryProduct(Long id) {
		GroceryProduct item = grepo.findById(id)
	                .orElseThrow(() -> new ResourceNotFoundException("Grocery Product not found with ID: " + id));
		grepo.delete(item);
	}

	@Override
	public List<GroceryProduct> getAllGroceryProduct() {
		return grepo.findAll();
	}

	@Override
	public GroceryProduct updateGroceryItem(Long id, GroceryProduct groceryDetails) {
		GroceryProduct item = grepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grocery Product not found with ID: " + id));

		item.setName(groceryDetails.getName());
		item.setCategory(groceryDetails.getCategory());
		item.setPrice(groceryDetails.getPrice());
		item.setQuantity(groceryDetails.getQuantity());

        return grepo.save(item);
	}

}
