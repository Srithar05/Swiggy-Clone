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
public class GroceryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private double price;
	
	private String weight;
	
	@Column(name = "image_url")
    private String imageUrl;
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "grocery_id")
	private GroceryCategory grocery;
}
