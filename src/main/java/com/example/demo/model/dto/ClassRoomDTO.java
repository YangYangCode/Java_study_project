package com.example.demo.model.dto;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ClassRoomDTO {
	private Long id;
	private String name;		
	private Integer	classRoomSize;	// 大小(人數)
	
//	private BookingFormDTO BookingForm;		// 預約表
	
	
//	private Set<Long> activitySchedulesIds;	// 另外由entity get
//	private Set<ClassTypeDTO> classTypes; 	// 可用課程類型
	

}
