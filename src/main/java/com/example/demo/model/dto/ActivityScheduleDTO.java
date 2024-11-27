package com.example.demo.model.dto;

import java.util.Date;
import java.util.HashSet;
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
	
	private Set<MemberDTO> signedMemberList = new HashSet<>(); 	// 會員列表
	private Integer maxSignNumber;
	private Integer currentSignNumber = signedMemberList.size(); 		// 已報名人數 - 會員列表數量
	
	private ClassRoomDTO classRoom ;	// 課程教室
	private ClassTypeDTO classType ;	// 課程類型
	private Set<FitnessInstructorDTO> fitnessInstructors = new HashSet<>();		// 教練們 
	
	private InformationDTO information;	// 詳細資訊
	
}
