package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.entity.MemberBookingForm;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.Equipment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClassTypeDTO {
	private Long id;
	private String name;	// 活動類別
	
	private List<ActivityScheduleDTO> activitySchedule;
	private Map<Long, String> classRoomIds;	
	private Map<Long, String> fitnessInstructorIds;
	
	
}
