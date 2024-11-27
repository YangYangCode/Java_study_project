package com.example.demo.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity	// 時間排表
public class FitnesslnstructorBookingForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 時間排表
	private Long id;
	
	private Date date;
	
	private String timePeriod;
	
	@Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
	private Boolean booking; 
	
	@OneToOne(mappedBy = "fitnesslnstructorBookingForm")
	private FitnessInstructor fitnessInstructor;
}
