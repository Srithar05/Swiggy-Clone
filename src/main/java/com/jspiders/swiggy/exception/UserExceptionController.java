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
	
	@ExceptionHandler(value = EmailAlreadyExistsException.class)
	public ResponseEntity<?> emailAlreadyExistsException(EmailAlreadyExistsException e,HttpServletRequest req)
	{
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.CONFLICT.getReasonPhrase());
		apiError.setStatus(HttpStatus.CONFLICT.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = PhonenoAlreadyExistsException.class)
	public ResponseEntity<?> phonenoAlreadyExistsException(PhonenoAlreadyExistsException e,HttpServletRequest req)
	{
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.CONFLICT.getReasonPhrase());
		apiError.setStatus(HttpStatus.CONFLICT.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.CONFLICT);
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
	
	@ExceptionHandler( value = IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentException(IllegalArgumentException e, HttpServletRequest req) {
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler( value = InvalidAuthenticationException.class)
	public ResponseEntity<?> invalidAuthendicationException(InvalidAuthenticationException e, HttpServletRequest req) {
		APIError apiError = new APIError();
		apiError.setTimeStamp(LocalDateTime.now());
		apiError.setError(HttpStatus.UNAUTHORIZED.getReasonPhrase());
		apiError.setStatus(HttpStatus.UNAUTHORIZED.value());
		apiError.setPath(req.getRequestURI());
		apiError.setMessage(e.getMessage());
		
		return new ResponseEntity<>(apiError, HttpStatus.UNAUTHORIZED);
	}
}
