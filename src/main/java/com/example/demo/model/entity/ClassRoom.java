
package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;		// *房號
	
	@Column(nullable = false)
	private String name;	// 房名
	
	@Column(columnDefinition = "Integer default 0")
	private Integer	classRoomSize;	// 大小(人數)
	
	@JsonIgnore
	@OneToMany(mappedBy = "classRoom", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private List<ActivitySchedule> activitySchedules;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
	@JsonManagedReference	// 管理方
	private Set<ClassType> classTypes; 	// 可用課程類型

	@JsonIgnore
	@OneToMany(mappedBy = "classRoom", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private Set<ClassRoomBookingForm> classRoomBookingForm;		// 預約表

}
