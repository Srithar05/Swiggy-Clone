package com.jspiders.swiggy.exception;

public class UnexpectedTypeException extends RuntimeException{

	public UnexpectedTypeException(String message) {
		super(message);
	}
	
	public UnexpectedTypeException() {
		super();
	}
}
