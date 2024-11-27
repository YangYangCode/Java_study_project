package com.example.demo.model.dto;

import java.util.Date;

import com.example.demo.model.entity.ClassRoom;

import lombok.Data;

@Data
public class ClassRoomBookingFormDTO {
	private Long id;
	private Date date;
	private String timePeriod;
	private Boolean booking; 

}
