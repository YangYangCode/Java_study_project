package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.entity.MemberBookingForm;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.Equipment;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoomDTO {
	private Long roomId;		// *房號
	private String roomName;	// 房名
	private Integer	roomSize;	// 大小(人數)
	
	private List<ClassType> classes = new ArrayList<>();		// 可用活動
	private List<Equipment> equipments= new ArrayList<>();	// 可用器材
	
	private MemberBookingForm appointmentForm;				// 預約表
}
