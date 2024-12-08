package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
//	@JsonIgnore
	@OneToMany(mappedBy = "classType", 
			fetch = FetchType.EAGER, 
			cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private List<ActivitySchedule> activitySchedule;
	
//	@ManyToMany(mappedBy = "classTypes")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="class_type_class_room", joinColumns = @JoinColumn(name= "class_type_id"))
	@MapKeyColumn(name = "class_room_id")
	@Column(name = "class_room_name")
	private Map<Long, String> classRooms;	
	
//	@ManyToMany(mappedBy = "classTypes")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(joinColumns = @JoinColumn(name= "class_type_id"))
	@MapKeyColumn(name = "fitness_instructor_id")
	@Column(name = "fitness_instructor_name")
	private Map<Long, String> fitnessInstructors;

	@Override
	public String toString() {
		return "ClassType [id=" + id + ", name=" + name + ", activitySchedule=" + activitySchedule + ", classRooms="
				+ classRooms + ", fitnessInstructors=" + fitnessInstructors + "]";
	}
	

}
