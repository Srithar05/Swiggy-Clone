package com.jspiders.swiggy.service;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.swiggy.dao.UserDao;
import com.jspiders.swiggy.dto.UserResponseDto;
import com.jspiders.swiggy.entity.User;
import com.jspiders.swiggy.exception.InvalidAuthenticationException;
import com.jspiders.swiggy.util.ResponseStructure;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private ModelMapper mapper;
	
	public ResponseStructure<UserResponseDto> registerUser(User user) {
		User registeredUser = userDao.registerUser(user);
		
		UserResponseDto responseDto = mapper.map(registeredUser, UserResponseDto.class);
		ResponseStructure<UserResponseDto> structure = new ResponseStructure<UserResponseDto>();
		structure.setData(responseDto);
		structure.setTimeStamp(LocalDateTime.now());
		structure.setMessage("User Account created successfully");
		structure.setStatusCode(201);
		
		return structure;
	}

	public ResponseStructure<UserResponseDto> login(String string, String password) {
		User login = userDao.login(string);
		
		if(login.getPhone().equals(string)&&login.getPassword().equals(password))
		{
			UserResponseDto map = mapper.map(login, UserResponseDto.class);
			ResponseStructure<UserResponseDto> structure = new ResponseStructure<>();
			structure.setData(map);
			structure.setTimeStamp(LocalDateTime.now());
			structure.setMessage("Login successfull");
			structure.setStatusCode(200);
			
			return structure;
		}
		else
		{
			throw new InvalidAuthenticationException("Incorrect Password!!!");
		}
	}
}

