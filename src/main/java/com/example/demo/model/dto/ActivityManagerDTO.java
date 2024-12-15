package com.example.demo.model.dto;

import java.util.List;
import java.util.Set;

import com.example.demo.model.UserDTO;
import com.example.demo.model.entity.ActivitySchedule;

import lombok.Data;

@Data
public class ActivityManagerDTO extends UserDTO {

	private Long id;		// *邊號
	private String name;		// 管理者姓名
	
//	private Set<Long> activityScheduleIds;	// 另外由entity get



}
