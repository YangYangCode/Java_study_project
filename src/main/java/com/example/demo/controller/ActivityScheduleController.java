package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ActivityScheduleService;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /activityschedule  (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有活動
 * GET    "/{id}" 獲取該活動資訊
 * GET	  "/{id}" 獲取活動參與成員
 * POST   "/"     新增活動
 * PUT    "/{id}" 更新活動
 * DELETE "/{id}" 刪除活動
 * ------------------------------------------
 * */

@RestController
@RequestMapping("/activityschedule")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ActivityScheduleController {
	
	@Autowired
	private ActivityScheduleService activityScheduleService;
	
	// 取得所有活動
	@GetMapping
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getAllActivitySchedule(){
		return ResponseEntity.ok(ApiResponse.success("查詢成功", activityScheduleService.getAllActivitySchedules()));
	}
	
	// 取得特定活動排程
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ActivityScheduleDTO>> getActivitySchedule(@PathVariable Long id) {
	    Optional<ActivityScheduleDTO> optActivityScheduleDTO = activityScheduleService.findActivityScheduleById(id);
	    if (optActivityScheduleDTO.isEmpty()) {
	        return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此活動"));
	    }
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", optActivityScheduleDTO.get()));
	}
	
	// 取得參與會員清單
	@GetMapping("/members/{id}")
	public ResponseEntity<ApiResponse<Map<Long, String>>> getMemberListByActivitySchedule(@PathVariable Long id){
		return ResponseEntity.ok(ApiResponse.success("查詢成功", activityScheduleService.findMemberListByActivitySchedule(id)));
	}
	
	// 新增活動
	@PostMapping
	public ResponseEntity<ApiResponse<ActivityScheduleDTO>> addActivitySchedule(@RequestBody ActivityScheduleDTO activityScheduleDTO) {
		System.out.println(activityScheduleDTO);
	    ActivityScheduleDTO newActivityScheduleDTO = activityScheduleService.saveActivitySchedule(activityScheduleDTO);
	    return ResponseEntity.ok(ApiResponse.success("新增成功", newActivityScheduleDTO));
	}
	
	// 修改活動資訊
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ActivityScheduleDTO>> updateActivitySchedule(@PathVariable Long id, @RequestBody ActivityScheduleDTO activityScheduleDTO) {
	    ActivityScheduleDTO updatedActivityScheduleDTO = activityScheduleService.updateActivitySchedule(activityScheduleDTO, id);
	    return ResponseEntity.ok(ApiResponse.success("修改成功", updatedActivityScheduleDTO));
	}

	// 刪除活動
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteActivitySchedule(@PathVariable Long id) {
	    activityScheduleService.deleteActivitySchedule(id);
	    return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
	
	
	
}
