package com.jspiders.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.swiggy.entity.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Integer>{

	
}
