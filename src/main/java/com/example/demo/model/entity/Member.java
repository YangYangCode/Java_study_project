package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.example.demo.model.User;
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
public class Member extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;	// *會員邊號
	
	@Column(nullable = false)
	private String name;	// 會員名稱
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private MemberBookingForm memberBookingForm;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "activity_schedule_id")) 
	@JsonManagedReference	// 管理方
	private Set<ActivitySchedule> activitySchedules; // 參加的活動
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="member_activity_schedule", joinColumns = @JoinColumn(name= "member_id")) // 活動id 欄名稱、主表的對應值
//	@Column(name = "activity_schedule_id")
//	private Set<Long> activityScheduleIds; // 參加的活動
	

}
