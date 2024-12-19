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
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ClassRoomService;

/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /classroom  (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有教室
 * GET    "/{id}" 獲取該教室
 * GET	  "/{id}" 獲取教室登入活動
 * POST   "/"     新增教室
 * PUT    "/{id}" 更新教室
 * DELETE "/{id}" 刪除教室
 * ------------------------------------------
 * */

@RestController
@RequestMapping("/classroom")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ClassRoomController {

	@Autowired
	private ClassRoomService classRoomService;
	
	// 獲取教室清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<ClassRoomDTO>>> getAllClassRoom(){
		return ResponseEntity.ok(ApiResponse.success("獲取教室清單成功", classRoomService.getAllClassRooms()));
	}
	
	// 取得特定教室
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ClassRoomDTO>> getClassRoom(@PathVariable Long id) {
	    Optional<ClassRoomDTO> optClassRoomDTO = classRoomService.findClassRoomById(id);
	    if (optClassRoomDTO.isEmpty()) {
	        return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此教室"));
	    }
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", optClassRoomDTO.get()));
	}
	
	// 取得教室登入活動
	@GetMapping("/list/{id}")
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getActivityScheduleListByClassRoom(@PathVariable Long id){
		return ResponseEntity.ok(ApiResponse.success("查詢成功", classRoomService.findActivityScheduleByClassRoom(id)));
	}
	
	// 新增教室
	@PostMapping
	public ResponseEntity<ApiResponse<ClassRoomDTO>> addClassRoom(@RequestBody ClassRoomDTO classRoomDTO) {
//		System.out.println(classRoomDTO);
		ClassRoomDTO newClassRoomDTO = classRoomService.saveClassRoom(classRoomDTO);
	    return ResponseEntity.ok(ApiResponse.success("新增成功", newClassRoomDTO));
	}
	
	// 修改教室
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ClassRoomDTO>> updateClassRoom(@PathVariable Long id, @RequestBody ClassRoomDTO classRoomDTO) {
	    ClassRoomDTO updatedClassRoomDTO = classRoomService.updateClassRoom(classRoomDTO, id);
	    return ResponseEntity.ok(ApiResponse.success("修改成功", updatedClassRoomDTO));
	}
	
	// 刪除教室
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteClassRoom(@PathVariable Long id) {
	    classRoomService.deleteClassRoom(id);
	    return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
	
	
}
