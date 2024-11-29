package com.example.demo.model;

import lombok.Data;

@Data
public abstract class UserDTO {
	private String username;
	private String password;
	private String salt;
	
}
