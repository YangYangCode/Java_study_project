package com.example.demo.model.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class FitnessInstructor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
//	@Column(name= "FitnessInstructor_id")
	private Integer FitnessInstructorId;		// *教練邊號
	
	@Column(name = "fitnessInstructor_name", nullable = false)
	private String fitnessInstructorName;		// 教練姓名
	
	// 有空再改成ManyToMany (可直接查詢class有哪些授課老師)
	@OneToMany(mappedBy = "FitnessInstructor", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name= "FitnessInstructor_id")
	private List<Class> classes = new ArrayList<>();	// 授課類型
	
	// 需修改
	@ManyToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private AppointmentForm appointmentForm;			// 排程表
}
