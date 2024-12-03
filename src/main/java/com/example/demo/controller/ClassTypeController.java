package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ClassTypeService;

@RestController
@RequestMapping("/classtype")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ClassTypeController {

	@Autowired
	private ClassTypeService classTypeService;
	
	@GetMapping
	public ResponseEntity<ApiResponse<List<ClassTypeDTO>>> getAllClassTypeRoom(){
		return ResponseEntity.ok(ApiResponse.success("獲取課程清單成功", classTypeService.getAllClassTypes()));
	}
}
