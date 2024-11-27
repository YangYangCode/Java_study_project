package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FitnessInstructor extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;		// *教練邊號
	
	@Column(nullable = false)
	private String name;		// 教練姓名
	
	@ManyToMany(mappedBy = "fitnessInstructors")
	private Set<ActivitySchedule> activitySchedules = new HashSet<>(); 		
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
	private Set<ClassType> classTypes = new HashSet<>(); 	// 可帶課程類型
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fitnesslnstructor_booking_form_id")
	private FitnesslnstructorBookingForm fitnesslnstructorBookingForm;		// 預約表
}
