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
	
    @OneToOne(mappedBy = "information")
    private ActivitySchedule activitySchedule;
}
