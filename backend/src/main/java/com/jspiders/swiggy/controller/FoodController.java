package com.jspiders.swiggy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.swiggy.entity.FoodItem;
import com.jspiders.swiggy.service.FoodService;
import com.jspiders.swiggy.util.ResponseStructure;

@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createFood(@RequestBody FoodItem foodItem, @RequestParam int categoryId) {
		ResponseStructure<FoodItem> food = foodService.createFood(foodItem,categoryId);
		return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getFoodsByCategoryId(@PathVariable int id) {
		ResponseStructure<List<FoodItem>> foodsByCategoryId = foodService.getFoodsByCategoryId(id);
		return new ResponseEntity<>(foodsByCategoryId, HttpStatus.OK);
	}
}
