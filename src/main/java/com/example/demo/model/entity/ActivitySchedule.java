package com.example.demo.model.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActivitySchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 活動編號
	private Long id;
	
	private Date date;	// 日期
	
	private String classTime; 	// 時間
	
	private Integer maxSignNumber;	// 可報名人數
	
//	private Integer currentSignNumber; // = memberHadSigned.size();	// 已報名人數 - 移到Dto產生
	
	
//	關聯
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "member_id")) 	
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name= "activity_schedule_id"))
	@Column(name = "member_id")		// Table 中 signedMemberId 列表
	private Set<Member> signedMemberIds; 			
	
	@ManyToOne
	@JoinColumn(name = "class_room_id")
	private ClassRoom classRoom ;
	
	@ManyToOne
	@JoinColumn(name = "class_type_id")  // 外鍵列，指向 該類別 主鍵
	private ClassType classType ;
	
//	@ManyToMany
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "fitness_instructor_id")) 	
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name= "activity_schedule_id"))
	@Column(name = "fitness_instructor_id")
	private Set<Long> fitnessInstructorIds; 		
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "infomation_id")
	private Information information;
	
	@ManyToOne
	@JoinColumn(name = "activityManager_id")
	private ActivityManager activityManager;

}
