package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;

// 課程類型
public interface ClassTypeService {
	// 查詢所有課程類型
	List<ClassTypeDTO> getAllClassTypes();
	
	// 查詢單一課程
	Optional<ClassTypeDTO> findClassTypeById(Long id);
	
	// 新增課程
	ClassTypeDTO saveClassType(ClassTypeDTO classTypeDTO);
	
	// 修改課程
	ClassTypeDTO updateClassType(ClassTypeDTO classTypeDTO, Long id);
	
	// 刪除課程
	void deleteClassType(Long id);
	
	// 根據課程類型取得活動		// 放classtype
	List<ActivityScheduleDTO> findActivityScheduleByClassType(Long classTypeId);
	
	
//	// 教室新增
//	Map<Long, String> addClassRoom(Long classTypeId, Long classRoomId);
//	
//	// 教室刪除
//	Map<Long,String> deleteClassRoom(Long classTypeId, Long classRoomId);
//	
//	// 教練新增
//	Map<Long, String> addFitnessInstructor(Long classTypeId, Long fitnessInstructorId);
//	
//	// 教練刪除
//	Map<Long, String> deleteFitnessInstructor(Long classTypeId, Long fitnessInstructorId);
	

	
}

