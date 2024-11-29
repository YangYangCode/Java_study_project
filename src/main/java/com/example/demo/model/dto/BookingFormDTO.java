package com.example.demo.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class BookingFormDTO {
	private Long id;
	private Date date;
	private String timePeriod;
	private Boolean booking; 
	
	private ClassRoomDTO classRoom;
	private FitnessInstructorDTO fitnessInstructor;
	private MemberDTO member;

}
