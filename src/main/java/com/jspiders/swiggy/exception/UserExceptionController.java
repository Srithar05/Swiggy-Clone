package com.jspiders.swiggy.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class UserExceptionController {
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<?> userNotFoundException(UserNotFoundException e, HttpServletRequest req) {
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.NOT_FOUND.getReasonPhrase());
		apiError.setStatus(HttpStatus.NOT_FOUND.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler( value = UnexpectedTypeException.class)
	public ResponseEntity<?> unexpectedTypeException(UnexpectedTypeException e, HttpServletRequest req) {
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
}
