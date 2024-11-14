package com.example.demo.model.entity;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Integer member_id;	// *會員邊號
	
	@Column(nullable = false)
	private String mrmber_name;	// 會員名稱
	
//	一對一
//	private ArrayList<ActivitySchedule> sing_up = new ArrayList<>();	// 已報名課程
}
