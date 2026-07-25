package com.jspiders.swiggy.exception;

public class EmailAlreadyExistsException extends RuntimeException{
	
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
	
	public EmailAlreadyExistsException() {
		super();
	}
}
