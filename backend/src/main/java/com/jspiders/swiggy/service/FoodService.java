package com.jspiders.swiggy.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.swiggy.dao.FoodDao;
import com.jspiders.swiggy.entity.FoodCategory;
import com.jspiders.swiggy.entity.FoodItem;
import com.jspiders.swiggy.exception.InvalidIdException;
import com.jspiders.swiggy.repository.FoodCategoryRepository;
import com.jspiders.swiggy.util.ResponseStructure;

@Service
public class FoodService {
	
	@Autowired
	private FoodDao foodDao;
	
	@Autowired
	private FoodCategoryRepository foodCategoryRepository;

	public ResponseStructure<FoodItem> createFood(FoodItem foodItem, int categoryId) {
		
		Optional<FoodCategory> optional = foodCategoryRepository.findById(categoryId);
		if(optional.isEmpty()) {
			throw new InvalidIdException("Food Category not found");
		}
		FoodCategory foodCategory = optional.get();
		foodItem.setCategory(foodCategory);
		
		FoodItem food = foodDao.createFood(foodItem);
		ResponseStructure<FoodItem> structure=new ResponseStructure<>();
		structure.setTimeStamp(LocalDateTime.now());
		structure.setData(food);
		structure.setMessage("New Food added successfully");
		structure.setStatusCode(201);
		
		return structure;
	}

	public ResponseStructure<List<FoodItem>> getFoodsByCategoryId(int id) {
		List<FoodItem> foodsByCategoryId = foodDao.getFoodsByCategoryId(id);
		ResponseStructure<List<FoodItem>> structure=new ResponseStructure<>();
		structure.setTimeStamp(LocalDateTime.now());
		structure.setData(foodsByCategoryId);
		structure.setMessage("All the Foods are listed");
		structure.setStatusCode(200);
		
		return structure;
	}

}
