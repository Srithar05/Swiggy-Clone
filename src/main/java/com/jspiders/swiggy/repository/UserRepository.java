package com.jspiders.swiggy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jspiders.swiggy.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByPhone(String phone);
	
	Optional<User> findByEmail(String email);
	
	boolean existsByPhone(String phone);
	
	boolean existsByEmail(String email);
	
	
}
