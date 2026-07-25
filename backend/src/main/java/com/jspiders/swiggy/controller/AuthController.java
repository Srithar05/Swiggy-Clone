package com.jspiders.swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.swiggy.dto.LoginRequest;
import com.jspiders.swiggy.dto.UserResponseDto;
import com.jspiders.swiggy.entity.User;
import com.jspiders.swiggy.service.UserService;
import com.jspiders.swiggy.util.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody User user) {
		ResponseStructure<UserResponseDto> registerUser = userService.registerUser(user);
		return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest) {
		ResponseStructure<UserResponseDto> login = userService.login(loginRequest.getPhone(), loginRequest.getPassword());
		return new ResponseEntity<>(login, HttpStatus.OK);
	}
}
