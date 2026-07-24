package com.jspiders.swiggy.exception;

public class InvalidAuthenticationException extends RuntimeException{
	
	public InvalidAuthenticationException(String message) {
		super(message);
	}

	public InvalidAuthenticationException() {
		super();
	}
}
