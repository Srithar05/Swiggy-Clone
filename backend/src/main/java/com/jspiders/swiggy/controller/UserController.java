package com.jspiders.swiggy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.swiggy.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
}
