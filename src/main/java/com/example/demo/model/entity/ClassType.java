package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
import jakarta.persistence.MapKeyColumn;
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
	
	@JsonIgnore
	@OneToMany(mappedBy = "classType", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private List<ActivitySchedule> activitySchedules;
	
	@ManyToMany(mappedBy = "classTypes", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private Set<ClassRoom> classRooms;	

	@ManyToMany(mappedBy = "classTypes", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private Set<FitnessInstructor> fitnessInstructors;


}
