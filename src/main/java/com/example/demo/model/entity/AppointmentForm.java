package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity	// 時間排表
public class AppointmentForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 時間排表
	private Integer AppointmentFormId;
}
