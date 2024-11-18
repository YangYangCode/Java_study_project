package com.example.demo.model.dto;

import java.util.ArrayList;

import com.example.demo.model.entity.ActivitySchedule;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDTO {
	private Integer member_id;	// *會員邊號
	private String mrmber_name;	// 會員名稱
	
	private ArrayList<ActivitySchedule> sing_up = new ArrayList<>();	// 已報名課程
}
