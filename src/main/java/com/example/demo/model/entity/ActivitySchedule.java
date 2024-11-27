package com.example.demo.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class ActivitySchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 活動編號
	private Long id;
	
	private Date date;	// 日期
	
	private String classTime; 	// 時間
	
	private Integer maxSignNumber;	// 可報名人數
	
//	private Integer currentSignNumber; // = memberHadSigned.lenght();	// 已報名人數 - 移到Dto產生
	
	
//	關聯
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "member_id")) 	
	private Set<Member> signedMemberList = new HashSet<>(); 			
	
	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private ClassRoom classRoom ;
	
	@ManyToOne
	@JoinColumn(name = "class_Type_id")  // 外鍵列，指向 該類別 主鍵
	private ClassType classType ;
	
	@ManyToMany
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "FitnessInstructor_id")) 	
	private Set<FitnessInstructor> fitnessInstructors = new HashSet<>(); 		
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "infomation_id")
	private Information information;

}
