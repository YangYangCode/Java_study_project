package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass	// 表示这是一个 JPA 超类，不能单独作为实体
public abstract class User {

	private String username;
	private String password;
	private String salt;
	
	@Column(columnDefinition = "LONGTEXT")
	private String imageBase64;
	
	/*
	 * seter放在service層
	 * */
}
