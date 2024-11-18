package com.example.demo.model.dto;

import java.time.LocalDateTime;

import com.example.demo.model.entity.Class;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Room;

public class ActivityScheduleDTO {
	private Long activityScheduleId;
	private Room room ;
	private FitnessInstructor fitnessInstructor ;
	private Class Class ;
	
	private Integer numberOfCanRegister;	// 可報名人數
	private Integer numberOfHaveSigned; // = memberHaveSigned.lenght();	// 已報名人
	private LocalDateTime classTime; // 課程時間
}
