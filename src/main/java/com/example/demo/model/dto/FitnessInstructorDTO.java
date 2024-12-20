package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.dto.BookingFormDTO;

import lombok.Data;

import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnesslnstructorBookingForm;

@Data
public class FitnessInstructorDTO {
	private Long id;		// *教練邊號
	private String name;		// 教練姓名
	
//	private BookingFormDTO BookingForm;		// 預約表
	 	
//	private Set<Long> activityScheduleIds;
//	private Set<ClassTypeDTO> classTypes; 	// 可帶課程類型
	
}
