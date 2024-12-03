package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	
//	@ManyToMany(mappedBy = "classTypes")
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name= "class_type_id"))
	@Column(name = "class_room_id")
	private Set<ClassRoom> classRoomIds;	
	
//	@ManyToMany(mappedBy = "classTypes")
	@ElementCollection
	@CollectionTable(joinColumns = @JoinColumn(name= "class_type_id"))
	@Column(name = "fitness_instructor_id")
	private Set<FitnessInstructor> fitnessInstructorIds;
	
	@OneToMany(mappedBy = "classType")
	private List<ActivitySchedule> activitySchedule;
	
}
