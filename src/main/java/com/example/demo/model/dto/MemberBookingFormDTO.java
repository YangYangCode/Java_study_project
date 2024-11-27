package com.example.demo.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MemberBookingFormDTO {
	private Long id;
	private Date date;
	private String timePeriod;
	private Boolean booking; 
}
