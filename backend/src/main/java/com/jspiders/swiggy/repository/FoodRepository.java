package com.jspiders.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.swiggy.entity.FoodItem;

public interface FoodRepository extends JpaRepository<FoodItem, Integer>{
	
	 List<FoodItem> findByCategoryId(int id);
}
