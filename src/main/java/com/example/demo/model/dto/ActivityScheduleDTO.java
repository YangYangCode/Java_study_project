package com.example.demo.model.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActivityScheduleDTO {
	private Long id;
	private LocalDate date;
	private String classTime;
	private Integer maxSignNumber;
	private String information;			// 詳細資訊
	
	private ActivityManagerDTO activityManager;	// 活動管理員 id
	private ClassRoomDTO classRoom ;	// 課程教室
	private ClassTypeDTO classType ;	// 課程類型
	private Map<Long, String> fitnessInstructors;	// 教練們 
	private Map<Long, String> signedMembers = new HashMap<>(); 	// 會員列表
	
	private Integer currentSignNumber = signedMembers.size(); 	// 已報名人數 - 會員列表數量

	public ActivityScheduleDTO(LocalDate date, String classTime, Integer maxSignNumber, String information,
			ActivityManagerDTO activityManager, ClassRoomDTO classRoom, ClassTypeDTO classType,
			Map<Long, String> fitnessInstructors, Map<Long, String> signedMembers) {
		super();
		this.date = date;
		this.classTime = classTime;
		this.maxSignNumber = maxSignNumber;
		this.information = information;
		this.activityManager = activityManager;
		this.classRoom = classRoom;
		this.classType = classType;
		this.fitnessInstructors = fitnessInstructors;
		this.signedMembers = signedMembers;
	}
	
	
}
