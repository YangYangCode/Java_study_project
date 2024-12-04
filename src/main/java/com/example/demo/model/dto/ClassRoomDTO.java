package com.example.demo.model.dto;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.entity.ClassRoomBookingForm;
import com.example.demo.model.entity.ClassType;

import lombok.Data;

@Data
public class ClassRoomDTO {
	private Long id;
	private String name;		
	private Integer	classRoomSize;	// 大小(人數)
	
	private Map<Long, String> classTypeIds; 	// 可用課程類型
	private List<ActivityScheduleDTO> activitySchedules;
	private BookingFormDTO BookingForm;		// 預約表
	
}
