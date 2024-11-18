package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Information {
	// 依賴於 ActivitySchedule 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long informationId;
	
	private String info;
	
//	// 這裡 A 類別依賴於 B 類別的主鍵
//    @OneToOne(mappedBy = "AS_infomation")
//    private ActivitySchedule activitySchedule;  // 這表示 依賴於 activity 主鍵
}
