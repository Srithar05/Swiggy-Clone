package com.jspiders.swiggy.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jspiders.swiggy.entity.User;
import com.jspiders.swiggy.exception.UserNotFoundException;
import com.jspiders.swiggy.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		User registeredUser = userRepository.save(user);
		return registeredUser;
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
