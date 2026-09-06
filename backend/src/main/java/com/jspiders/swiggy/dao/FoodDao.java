package com.jspiders.swiggy.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.swiggy.entity.FoodItem;
import com.jspiders.swiggy.exception.InvalidIdException;
import com.jspiders.swiggy.repository.FoodRepository;

@Repository
public class FoodDao {
	
	@Autowired
	private FoodRepository foodRepository;

	public FoodItem createFood(FoodItem foodItem) {
		return foodRepository.save(foodItem);
	}

	public List<FoodItem> getFoodsByCategoryId(int id) {
		List<FoodItem> byCategoryId = foodRepository.findByCategoryId(id);
		if(byCategoryId.isEmpty()) {
			throw new InvalidIdException("Food Category is not avilable");
		}
		return byCategoryId;
	}

}
