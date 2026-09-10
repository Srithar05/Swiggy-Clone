package com.jspiders.swiggy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.swiggy.dao.GroceryDao;
import com.jspiders.swiggy.entity.GroceryCategory;
import com.jspiders.swiggy.entity.GroceryItem;
import com.jspiders.swiggy.exception.InvalidIdException;
import com.jspiders.swiggy.repository.GroceryCategoryRepository;
import com.jspiders.swiggy.util.ResponseStructure;

@Service
public class GroceryService {
	
	@Autowired
	private GroceryDao groceryDao;

	@Autowired 
	private GroceryCategoryRepository groceryCategoryRepository;
	
	public ResponseStructure<GroceryItem> createGrocery(GroceryItem groceryItem, int groceryId) {
		
		Optional<GroceryCategory> optional = groceryCategoryRepository.findById(groceryId);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Grocery Category not found");
		}
		GroceryCategory groceryCategory = optional.get();
		groceryItem.setGrocery(groceryCategory);
		
		GroceryItem grocery = groceryDao.createGrocery(groceryItem);
		ResponseStructure<GroceryItem> structure=new ResponseStructure<>();
		structure.setTimeStamp(LocalDateTime.now());
		structure.setData(grocery);
		structure.setMessage("New Grocery added successfully");
		structure.setStatusCode(201);
		
		return structure;
	}

	public ResponseStructure<List<GroceryItem>> getGroceryByGroceryId(int id) {
		List<GroceryItem> groceryByGroceryId = groceryDao.getGroceryByGroceryId(id);
		ResponseStructure<List<GroceryItem>> structure=new ResponseStructure<>();
		structure.setTimeStamp(LocalDateTime.now());
		structure.setData(groceryByGroceryId);
		structure.setMessage("All the Groceries are listed");
		structure.setStatusCode(200);
		
		return structure;
	}

}
