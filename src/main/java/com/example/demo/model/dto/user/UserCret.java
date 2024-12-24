package com.example.demo.model.dto.user;

import lombok.Data;

@Data
public class UserCret {
	
	private Long id;
	private String type;
	private Boolean isLoggedIn;
	
}
