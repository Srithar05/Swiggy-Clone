package com.jspiders.swiggy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
	private String phone;
	
	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^[a-zA-Z0-9@$#]*$", message = "Password can contain letters, numbers and @ $ # symbols only")
	@Size(min = 5, max = 16)
	private String password;
}
