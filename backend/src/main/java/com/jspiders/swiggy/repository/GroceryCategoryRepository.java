package com.jspiders.swiggy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.swiggy.entity.GroceryCategory;

public interface GroceryCategoryRepository extends JpaRepository<GroceryCategory, Integer>{

}
