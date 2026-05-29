package com.jspiders.swiggy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private int userId;
	
	@NotBlank(message = "Name must not be empty")
	@Size(min = 3, max = 15, message = "Name should contain 3 to 15 characters")
	private String userName;
	
	
	@NotBlank(message = "Phone number is required")
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
	private String phone;
	
	@NotBlank(message = "Email is required")
	@Email(message = "Please enter valid email")
	private String email;
	
	@NotBlank(message = "Password is required")
	@Pattern(regexp = "^[a-zA-Z0-9@$#]*$", message = "Password can contain letters, numbers and @ $ # symbols only")
	@Size(min = 5, max = 16)
	private String password;
}
