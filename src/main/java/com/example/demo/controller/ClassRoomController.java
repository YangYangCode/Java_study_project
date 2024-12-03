package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ClassRoomService;

@RestController
@RequestMapping("/classroom")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ClassRoomController {

	@Autowired
	private ClassRoomService classRoomService;
	
	// 獲取房間清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<ClassRoomDTO>>> getAllClassRoom(){
		return ResponseEntity.ok(ApiResponse.success("獲取教室清單成功", classRoomService.getAllClassRooms()));
	}
}
