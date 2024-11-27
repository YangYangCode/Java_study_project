package com.example.demo.model.dto;

import java.util.List;

import com.example.demo.model.entity.ActivitySchedule;

import lombok.Data;

@Data
public class ActivityManagerDTO {

	private Long id;		// *邊號
	private String name;		// 管理者姓名
	
	private List<ActivitySchedule> activitySchedules;
	
}
