package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;

// 教室CRDU邏輯
public interface ClassRoomService {
	// 查詢所有教室
	List<ClassRoomDTO> getAllClassRooms();
	
	// 查詢單一教室
	Optional<ClassRoomDTO> findClassRoomById(Long id);
	
	// 新增教室
	ClassRoomDTO saveClassRoom(ClassRoomDTO classRoomDTO);
	
	// 修改教室
	ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO, Long id);
	
	// 刪除教室
	void deleteClassRoom(Long id);
	
	// 新增課程類型
	Map<Long,String> addClassType(Long classRoomId, Long classTypeId);
	
	// 刪除課程類型
	Map<Long,String> deleteClassType(Long classRoomId, Long classTypeId);

	
	// 活動關聯?	mappingBy，不需要
	
	
	// 查詢教室Booking		// 在BookingForm
	
}
