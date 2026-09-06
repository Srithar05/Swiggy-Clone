package com.jspiders.swiggy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FoodItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private double price;
	
	private double rating;
	
	@Column(name = "image_url")
    private String imageUrl;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private FoodCategory category;
}
