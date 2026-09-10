package com.jspiders.swiggy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.swiggy.entity.GroceryItem;
import com.jspiders.swiggy.exception.InvalidIdException;
import com.jspiders.swiggy.repository.GroceryRepository;

@Repository
public class GroceryDao {
	
	@Autowired
	private GroceryRepository groceryRepository;

	public GroceryItem createGrocery(GroceryItem groceryItem) {
		return groceryRepository.save(groceryItem);
	}

	public List<GroceryItem> getGroceryByGroceryId(int id) {
		List<GroceryItem> byGroceryId = groceryRepository.findByGroceryId(id);
		if(byGroceryId.isEmpty()) {
			throw new InvalidIdException("Grocery Category is not available");
		}
		return byGroceryId;
	}

}
