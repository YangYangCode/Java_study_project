package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;

// 課程類型
public interface ClassTypeService {
	// 查詢所有課程類型
	List<ClassTypeDTO> getAllClassTypes();
	
	// 新增課程
	ClassTypeDTO saveClassType(ClassTypeDTO classTypeDTO);
	
	// 修改課程
	ClassTypeDTO updateClassType(ClassTypeDTO classTypeDTO, Long id);
	
	// 刪除課程
	void deleteClassType(Long id);
	
	// 教室新增
	Map<Long, String> addClassRoom(Long classTypeId, Long classRoomId);
	
	// 教室刪除
	Map<Long,String> deleteClassRoom(Long classTypeId, Long classRoomId);
	
	// 教練新增
	Map<Long, String> addFitnessInstructor(Long classTypeId, Long fitnessInstructorId);
	
	// 教練刪除
	Map<Long, String> deleteFitnessInstructor(Long classTypeId, Long fitnessInstructorId);
}

