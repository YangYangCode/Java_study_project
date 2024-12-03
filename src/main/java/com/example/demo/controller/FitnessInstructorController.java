package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.FitnessInstructorService;

@RestController
@RequestMapping("/instructor")
public class FitnessInstructorController {

	@Autowired
	private FitnessInstructorService fitnessInstructorService;
	
	// 獲取教練清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<FitnessInstructorDTO>>> getAllFitnessInstructor(){
		return ResponseEntity.ok(ApiResponse.success("獲取教練清單成功", fitnessInstructorService.getAllFitnessInstructors()));
	}
}