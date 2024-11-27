package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.entity.MemberBookingForm;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.Equipment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClassTypeDTO {
	private Long id;
	private String name;	// 活動類別
	
}
