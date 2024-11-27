package com.example.demo.model.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
	private Set<ClassType> classTypes = new HashSet<>(); 	// 可用課程類型
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "class_room_booking_form_id")
	private ClassRoomBookingForm classRoomBookingForm;		// 預約表
	
	@OneToMany(mappedBy = "classRoom")
	private List<ActivitySchedule> activitySchedule;
	
	
	
	
//	// 依賴於這個 Room 的 equipments table
//	@ManyToMany(cascade = CascadeType.ALL, orphanRemoval = true)
//	@JoinColumn(name = "room_id")
//	private List<Equipment> equipments= new ArrayList<>();	// 可用器材
		

}
