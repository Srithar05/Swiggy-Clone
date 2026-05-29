package com.jspiders.swiggy.exception;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class APIError {
	
	private LocalDateTime timeStamp;
	private int status;
	private String error;
	private String path;
	private String message;
}
