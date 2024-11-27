package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.entity.MemberBookingForm;
import com.example.demo.model.entity.ClassType;

public class FitnessInstructorDTO {
	private Long FitnessInstructorId;		// *教練邊號
	private String fitnessInstructorName;		// 教練姓名
	
	private List<ClassType> classes = new ArrayList<>();	// 授課類型
	private MemberBookingForm appointmentForm;			// 排程表
}
