package com.example.demo.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass	// 表示这是一个 JPA 超类，不能单独作为实体
public abstract class BookingForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 時間排表
	private Long id;
	
	private LocalDate date;
	
	private String timePeriod;
}
