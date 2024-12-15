package com.example.demo.model;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public abstract class UserDTO {
	private String username;
	private String password;
	private String salt;
	
	private String imageBase64;
	
}
