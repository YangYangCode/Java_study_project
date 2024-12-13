package com.example.demo.model.dto;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class ClassRoomDTO {
	private Long id;
	private String name;		
	private Integer	classRoomSize;	// 大小(人數)
	
	private Map<Long, String> classTypes; 	// 可用課程類型
	private List<ActivityScheduleDTO> activitySchedules;	// 另外由entity get
	private BookingFormDTO BookingForm;		// 預約表
	@Override
	public String toString() {
		return "ClassRoomDTO [id=" + id + ", name=" + name + ", classRoomSize=" + classRoomSize + ", classTypes="
				+ classTypes + ", BookingForm=" + BookingForm + "]";
	}
	
	
}
