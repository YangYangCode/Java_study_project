package com.example.demo.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Information;
import com.example.demo.model.entity.Member;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ActivityScheduleDTO {
	private Long id;
	private Date date;
	private String classTime;
	private Integer maxSignNumber;
	
	private ClassRoomDTO classRoom ;	// 課程教室
	private ClassTypeDTO classType ;	// 課程類型
	private ActivityManagerDTO activityManager;
	private InformationDTO information;	// 詳細資訊
	
	private Map<Long, String> signedMemberIds; 	// 會員列表
	private Map<Long, String> fitnessInstructorIds;	// 教練們 
	
	private Integer currentSignNumber = signedMemberIds.size(); 	// 已報名人數 - 會員列表數量
	
}
