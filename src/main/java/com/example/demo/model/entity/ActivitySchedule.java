 package com.example.demo.model.entity;

import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActivitySchedule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 活動編號
	private Long id;
	private Date date;				// 日期
	private String classTime; 		// 時間
	private Integer maxSignNumber;	// 可報名人數
	
	@Column(columnDefinition = "LONGTEXT")
	private String information;		// 詳細內容
	
	
//	關聯
	
	@ManyToOne		//	@JoinColumn(name = "activity_manager_id")	@JsonIgnore
	private ActivityManager activityManager;
			
	@ManyToOne		//	@JoinColumn(name = "class_room_id")		@JsonIgnore
	private ClassRoom classRoom ;
	
	@ManyToOne		//	@JoinColumn(name = "class_type_id")  	@JsonIgnore
	private ClassType classType ;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "fitness_instructor_id"))
	@JsonManagedReference	// 管理方
	private Set<FitnessInstructor> fitnessInstructors;
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="activity_schedule_fitness_instructor", joinColumns = @JoinColumn(name= "activity_schedule_id"))
//	@MapKeyColumn(name = "fitness_instructor_id")
//	@Column(name = "fitness_instructor_name")
//	private Map<Long, String> fitnessInstructors;
	
	@ManyToMany(mappedBy = "activitySchedules")
	@JsonBackReference	// 被管理方
	private Set<Member> signedMembers; 
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="activity_schedule_member", joinColumns = @JoinColumn(name= "activity_schedule_id"))
//	@MapKeyColumn(name = "member_id")
//	@Column(name = "member_name")		// Table 中 member_id 欄名稱
//	private Map<Long, String> signedMembers; 

	
	

}
