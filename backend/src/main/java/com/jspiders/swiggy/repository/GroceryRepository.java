package com.jspiders.swiggy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.swiggy.entity.GroceryItem;

public interface GroceryRepository extends JpaRepository<GroceryItem, Integer>{
	
	List<GroceryItem> findByGroceryId(int id);
}
