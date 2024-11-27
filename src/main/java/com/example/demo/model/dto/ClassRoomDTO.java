package com.example.demo.model.dto;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.entity.ClassRoomBookingForm;
import com.example.demo.model.entity.ClassType;

import lombok.Data;

@Data
public class ClassRoomDTO {
	private Long id;
	private String name;		
	private Integer	classRoomSize;	// 大小(人數)
	
	private Set<ClassTypeDTO> classTypes = new HashSet<>(); 	// 可用課程類型
	private ClassRoomBookingFormDTO classRoomBookingForm;		// 預約表
	
}
