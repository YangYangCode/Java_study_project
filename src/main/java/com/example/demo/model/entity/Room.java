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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
//	@Column(name= "room_id")
	private Integer roomId;		// *房號
	
	@Column(name= "room_name", nullable = false)
	private String roomName;	// 房名
	
	@Column(name= "room_size", columnDefinition = "Integer default 0")
	private Integer	roomSize;	// 大小(人數)
	
	
	// 有空再加，未實作先空白
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "room_id")
	private List<Class> classes = new ArrayList<>();	// 可用活動
	
	@OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "room_id")
	private List<Equipment> equipments;					// 可用器材
		
	// 需修改
	@ManyToMany(mappedBy = "room", cascade = CascadeType.ALL)
	private AppointmentForm appointmentForm;			// 預約表
}
