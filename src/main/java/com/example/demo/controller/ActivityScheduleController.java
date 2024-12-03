package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ActivityScheduleService;

@RestController
@RequestMapping("/activityschedule")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ActivityScheduleController {
	
	@Autowired
	private ActivityScheduleService activityScheduleService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getAllActivitySchedule(){
		return ResponseEntity.ok(ApiResponse.success("查詢成功", activityScheduleService.getAllActivitySchedules()));
	}
	
//	@PostMapping("/add/{}")
//	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> addAllActivitySchedule(
//			@PathVariable Date date, @PathVariable String classTime, @PathVariable Integer maxSignNumber,
//			@PathVariable List<Long> signedMember, @PathVariable List<Long> fitnessInstructorsId, @PathVariable Long classRoomId, 
//			@PathVariable Long classTypeId, @PathVariable Long activityManagerId, @PathVariable String information){
//		
//		
//		
//		
//		return ResponseEntity.ok(ApiResponse.success("查詢成功", activityScheduleService.getAllActivitySchedules()));
//	}
	
	
	
	
}
