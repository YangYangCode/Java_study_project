package com.example.demo.model.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ClassTypeDTO {
	private Long id;
	private String name;	// 活動類別
	
	private Set<Long> activityScheduleIds;		// 另外由entity get
	private Map<Long, String> classRooms;	
	private Map<Long, String> fitnessInstructors;

	
	
}
