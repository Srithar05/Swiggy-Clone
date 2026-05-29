package com.jspiders.swiggy.dto;

import lombok.Data;

@Data
public class UserResponseDto {
	private int userId;
	private String userName;
	private long phone;
	private String email;
}
