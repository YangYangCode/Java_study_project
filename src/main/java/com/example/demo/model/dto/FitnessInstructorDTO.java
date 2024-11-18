package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.entity.AppointmentForm;
import com.example.demo.model.entity.Class;

public class FitnessInstructorDTO {
	private Long FitnessInstructorId;		// *教練邊號
	private String fitnessInstructorName;		// 教練姓名
	
	private List<Class> classes = new ArrayList<>();	// 授課類型
	private AppointmentForm appointmentForm;			// 排程表
}
