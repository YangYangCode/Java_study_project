package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;
	
	@Column(nullable = false)
	private String name;		// 課程名稱
	
	@ManyToMany(mappedBy = "classTypes")
	private Set<ClassRoom> classRooms;	
	
	@ManyToMany(mappedBy = "classTypes")
	private Set<FitnessInstructor> fitnessInstructors;
	
	@OneToMany(mappedBy = "classType")
	private List<ActivitySchedule> activitySchedule;
	
}
