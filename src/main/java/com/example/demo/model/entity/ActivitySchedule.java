package com.example.demo.model.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ActivitySchedule {
	
	// 複合主建
	
	@Id
	@Column(name = "activitySchedule_id", nullable = false)	// 活動編號
	private Long activityScheduleId;
	
	@ManyToOne
	@JoinColumn(name = "room_id")  // 外鍵列，指向 該類別 主鍵
	private Room room ;
	
	@ManyToOne
	@JoinColumn(name = "FitnessInstructor_id")  // 外鍵列，指向 該類別 主鍵
	private FitnessInstructor fitnessInstructor ;
	
	@ManyToOne
	@JoinColumn(name = "class_name")  // 外鍵列，指向 該類別 主鍵
	private Class Class ;

	
	// 其餘屬性
	
//	@Column(name = "number_of_can_register")
	private Integer numberOfCanRegister;	// 可報名人數
	
//	@Column(name = "number_of_have_signed")		// 拿掉?
	private Integer numberOfHaveSigned; // = memberHaveSigned.lenght();	// 已報名人數
			
//	@Column(name = "class_time")
	private LocalDateTime classTime; // 課程時間
	
	// by using 活動編碼 (新增OneToOne)
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "infomation")
	private Information information;		// 詳細內容 
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "Signed_member")
	private List<Member> memberHaveSigned = new ArrayList<>();	// 已報名會員清單
}
