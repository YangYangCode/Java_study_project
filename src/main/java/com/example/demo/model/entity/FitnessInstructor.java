package com.example.demo.model.entity;

import java.util.Map;
import java.util.Set;

import com.example.demo.model.User;

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
import jakarta.persistence.MapKeyColumn;
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
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fitnesslnstructor_booking_form_id")
	private FitnesslnstructorBookingForm fitnesslnstructorBookingForm;		// 預約表
	
//	@ManyToMany(mappedBy = "fitnessInstructors")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="fitness_instructor_activity_schedule", joinColumns = @JoinColumn(name= "fitness_instructor_id"))
	@Column(name = "activity_schedule_id")
	private Set<Long> activityScheduleIds; 		
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="fitness_instructor_class_type", joinColumns = @JoinColumn(name= "fitness_instructor_id"))
	@MapKeyColumn(name = "class_type_id")
	@Column(name = "class_type_name")
	private Map<Long, String> classTypes; 	// 可帶課程類型
}
