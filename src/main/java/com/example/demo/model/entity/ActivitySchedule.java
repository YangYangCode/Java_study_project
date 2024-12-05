package com.example.demo.model.entity;

import java.util.Date;
import java.util.Map;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
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

	
//	關聯
			
	@ManyToOne
	@JoinColumn(name = "class_room_id")
	private ClassRoom classRoom ;
	
	@ManyToOne
	@JoinColumn(name = "class_type_id")  // 外鍵列，指向 該類別 主鍵
	private ClassType classType ;
	
	@ManyToOne
	@JoinColumn(name = "activity_manager_id")
	private ActivityManager activityManager;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "infomation_id")
	private Information information;
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "member_id")) 	
	@ElementCollection
	@CollectionTable(name="activity_schedule_member", joinColumns = @JoinColumn(name= "activity_schedule_id"))
	@MapKeyColumn(name = "member_id")
	@Column(name = "member_name")		// Table 中 member_id 欄名稱
	private Map<Long, String> signedMembers; 
	
//	@ManyToMany
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "fitness_instructor_id")) 	
	@ElementCollection
	@CollectionTable(name="activity_schedule_member", joinColumns = @JoinColumn(name= "activity_schedule_id"))
	@MapKeyColumn(name = "fitness_instructor_id")
	@Column(name = "fitness_instructor_name")
	private Map<Long, String> fitnessInstructors; 

}
