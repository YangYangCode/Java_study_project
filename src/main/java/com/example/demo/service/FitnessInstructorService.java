package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.example.demo.model.dto.FitnessInstructorDTO;

// 教練
public interface FitnessInstructorService {
	// 查詢所有教練
	List<FitnessInstructorDTO> getAllFitnessInstructors();
	
	// 查詢單一教練
	Optional<FitnessInstructorDTO> findFitnessInstructorById(Long id);
	
	// 新增教練
	FitnessInstructorDTO saveFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO);
	
	// 修改教練
	FitnessInstructorDTO updateFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO, Long id);
	
	// 刪除教練
	void deleteFitnessInstructor(Long id);
	
	
	// 新增可帶課程
	Map<Long, String> addClassType(Long fitnessInstructorId, Long classTypeId);
	
	// 刪除可帶課程
	Map<Long, String> deleteClassType(Long fitnessInstructorId, Long classTypeId);
	
	// 新增活動
	Set<Long> addActivitySchedule(Long fitnessInstructorId, Long activityScheduleId);
	
	// 刪除活動
	Set<Long> deleteActivitySchedule(Long fitnessInstructorId, Long activityScheduleId);
	
	// 查詢單一教練Booking		// 在BookingForm
}

