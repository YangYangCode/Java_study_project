package com.example.demo.model.dto;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityScheduleDTO {
	private Long activityScheduleId;
	private ClassRoom room ;
	private FitnessInstructor fitnessInstructor ;
	private ClassType classType ;
	
	private Integer numberOfCanRegister;	// 可報名人數
	private Integer numberOfHaveSigned; // = memberHaveSigned.lenght();	// 已報名人
	private String classTime; // 課程時間
}
