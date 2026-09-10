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

import com.jspiders.swiggy.entity.GroceryItem;
import com.jspiders.swiggy.service.GroceryService;
import com.jspiders.swiggy.util.ResponseStructure;

@RestController
@RequestMapping("/grocery")
public class GroceryController {
	
	@Autowired
	private GroceryService groceryService;
	
	@PostMapping("/create")
	public ResponseEntity<?> createGrocery(@RequestBody GroceryItem groceryItem,@RequestParam int groceryId) {
		ResponseStructure<GroceryItem> grocery = groceryService.createGrocery(groceryItem,groceryId);
		return new ResponseEntity<>(grocery,HttpStatus.CREATED);
	}
	
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getGroceryByGroceryId(@PathVariable int id) {
		ResponseStructure<List<GroceryItem>> groceryByGroceryId = groceryService.getGroceryByGroceryId(id);
		return new ResponseEntity<>(groceryByGroceryId, HttpStatus.OK);
	}
}
