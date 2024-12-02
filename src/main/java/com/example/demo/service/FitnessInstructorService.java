package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.FitnessInstructorDTO;

// 教練
public interface FitnessInstructorService {
	// 查詢所有教練
	List<FitnessInstructorDTO> findAllFitnessInstructors();
	
	// 查詢單一教練Booking
	// 在BookingForm
	
	// 新增教練
	Optional<FitnessInstructorDTO> addFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO);
	
	// 修改教練
	Optional<FitnessInstructorDTO> updateFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO, Long id);
	
	// 刪除教練
	Optional<FitnessInstructorDTO> deleteFitnessInstructor(Long id);
}

