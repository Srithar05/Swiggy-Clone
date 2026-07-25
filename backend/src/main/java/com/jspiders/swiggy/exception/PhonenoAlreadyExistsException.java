package com.jspiders.swiggy.exception;

public class PhonenoAlreadyExistsException extends RuntimeException{
	
	public PhonenoAlreadyExistsException(String message) {
		super(message);
	}
	
	public PhonenoAlreadyExistsException() {
		super();
	}

}
