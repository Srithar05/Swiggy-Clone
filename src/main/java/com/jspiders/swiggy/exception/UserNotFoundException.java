package com.jspiders.swiggy.exception;

public class UserNotFoundException extends RuntimeException{
	
	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException() {
		super();
	}
}
