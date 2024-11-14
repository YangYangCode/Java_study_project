package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Information {
	// 依賴於 ActivitySchedule 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	
	// 這裡 A 類別依賴於 B 類別的主鍵
    @ManyToOne
    @JoinColumn(name = "activitySchedule_id")  // 外鍵列，指向 activity 主鍵
    private ActivitySchedule activitySchedule;  // 這表示 依賴於 activity 主鍵
}
