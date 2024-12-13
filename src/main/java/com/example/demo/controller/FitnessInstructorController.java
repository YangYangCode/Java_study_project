package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.FitnessInstructorService;

/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /instructor (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有教練
 * GET    "/{id}" 獲取該教練
 * GET	  "/{id}" 獲取教練登入活動
 * POST   "/"     新增教練
 * PUT    "/{id}" 更新教練
 * DELETE "/{id}" 刪除教練
 * ------------------------------------------
 * */

@RestController
@RequestMapping("/instructor")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class FitnessInstructorController {

	@Autowired
	private FitnessInstructorService fitnessInstructorService;
	
	// 獲取教練清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<FitnessInstructorDTO>>> getAllFitnessInstructor(){
		return ResponseEntity.ok(ApiResponse.success("獲取教練清單成功", fitnessInstructorService.getAllFitnessInstructors()));
	}
	
	// 取得特定教練
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<FitnessInstructorDTO>> getFitnessInstructor(@PathVariable Long id) {
	    Optional<FitnessInstructorDTO> optFitnessInstructorDTO = fitnessInstructorService.findFitnessInstructorById(id);
	    if (optFitnessInstructorDTO.isEmpty()) {
	        return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此健身教練"));
	    }
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", optFitnessInstructorDTO.get()));
	}
	
	// 取得教練登入活動
	@GetMapping("/list/{id}")
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getActivityScheduleListByFitnessInstructor(@PathVariable Long id) {
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", fitnessInstructorService.findActivityScheduleByFitnessInstructor(id)));
	}

	// 新增健身教練
	@PostMapping
	public ResponseEntity<ApiResponse<FitnessInstructorDTO>> addFitnessInstructor(@RequestBody FitnessInstructorDTO fitnessInstructorDTO) {
	    FitnessInstructorDTO newFitnessInstructorDTO = fitnessInstructorService.saveFitnessInstructor(fitnessInstructorDTO);
	    return ResponseEntity.ok(ApiResponse.success("新增成功", newFitnessInstructorDTO));
	}

	// 修改健身教練資訊
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<FitnessInstructorDTO>> updateFitnessInstructor(@PathVariable Long id, @RequestBody FitnessInstructorDTO fitnessInstructorDTO) {
	    FitnessInstructorDTO updatedFitnessInstructorDTO = fitnessInstructorService.updateFitnessInstructor(fitnessInstructorDTO, id);
	    return ResponseEntity.ok(ApiResponse.success("修改成功", updatedFitnessInstructorDTO));
	}

	// 刪除健身教練
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteFitnessInstructor(@PathVariable Long id) {
	    fitnessInstructorService.deleteFitnessInstructor(id);
	    return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
	
}