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

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ActivityManagerService;

/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /activitymanager  (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有活動管理員
 * GET    "/{id}" 獲取該活動管理員資訊
 * GET    "/{id}" 獲取該活動管理員所有活動
 * PUT    "/{id}" 更新活動管理員
 * POST   "/"     新增活動管理員
 * DELETE "/{id}" 刪除活動管理員
 * ------------------------------------------
 * */



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
	
	// 取得特定管理員
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ActivityManagerDTO>> getActivityManager(@PathVariable Long id){
		Optional<ActivityManagerDTO> optActivityManagerDTO = activityManagerService.findActivityManagerById(id);
		if (optActivityManagerDTO.isEmpty()) {
		    return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此活動管理員"));
		}
		return ResponseEntity.ok(ApiResponse.success("查詢成功", optActivityManagerDTO.get()));
	}
	
	// 取得管理員管理活動清單
	@GetMapping("/list/{id}")
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getAMASList(@PathVariable Long id){
		Optional<ActivityManagerDTO> optActivityManagerDTO = activityManagerService.findActivityManagerById(id);
		if (optActivityManagerDTO.isEmpty()) {
		    return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此活動管理員"));
		}
		List<ActivityScheduleDTO> ASList = activityManagerService.findActivityScheduleByActivityManager(id);
		return ResponseEntity.ok(ApiResponse.success("查詢成功", ASList));
	}
	
	// 新增活動管理員
	@PostMapping
	public ResponseEntity<ApiResponse<ActivityManagerDTO>> addActivityManager(@RequestBody ActivityManagerDTO activityManagerDTO){
		ActivityManagerDTO newActivityManagerDTO = activityManagerService.saveActivityManager(activityManagerDTO);
		return ResponseEntity.ok(ApiResponse.success("新增成功", newActivityManagerDTO));
	}
	
	// 修改活動管理員資訊
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ActivityManagerDTO>> updateActivityManager(@PathVariable Long id, @RequestBody ActivityManagerDTO activityManagerDTO){
		ActivityManagerDTO updateActivityManagerDTO = activityManagerService.updateActivityManager(activityManagerDTO, id);
		return ResponseEntity.ok(ApiResponse.success("修改成功", updateActivityManagerDTO));
	}
	
	// 刪除活動管理員
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteActivityManager(@PathVariable Long id){
		activityManagerService.deleteActivityManager(id);
		return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
	
	
	
	

}
