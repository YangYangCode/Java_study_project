package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ActivityManagerService;

@RestController
@RequestMapping("/activitymanager")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ActivityManagerController {
	
	@Autowired
	private ActivityManagerService activityManagerService;
	
	// 獲取管理員清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<ActivityManagerDTO>>> getAllActivityManager(){
		return ResponseEntity.ok(ApiResponse.success("獲取管理員清單成功", activityManagerService.getAllActivityManagers()));
	}

}
