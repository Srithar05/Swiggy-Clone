package com.jspiders.swiggy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.swiggy.entity.User;
import com.jspiders.swiggy.exception.EmailAlreadyExistsException;
import com.jspiders.swiggy.exception.PhonenoAlreadyExistsException;
import com.jspiders.swiggy.exception.UserNotFoundException;
import com.jspiders.swiggy.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		if(userRepository.existsByPhone(user.getPhone()))
		{
			throw new PhonenoAlreadyExistsException("Phone number already registered! Please login.");
		}
		if(userRepository.existsByEmail(user.getEmail()))
		{
			throw new EmailAlreadyExistsException("Email already registered! Please login.");
		}
		
		return userRepository.save(user);
	}

	public User login(String phone) {
		Optional<User> optional = userRepository.findByPhone(phone);
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			throw new UserNotFoundException("User not found! Please signup.");
		}
	}
}
