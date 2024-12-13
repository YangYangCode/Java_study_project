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
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.ClassTypeService;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /classtype  (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有課程
 * GET    "/{id}" 獲取該課程
 * GET	  "/{id}" 獲取課程登入活動
 * POST   "/"     新增課程
 * PUT    "/{id}" 更新課程
 * DELETE "/{id}" 刪除課程
 * ------------------------------------------
 * */

@RestController
@RequestMapping("/classtype")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class ClassTypeController {

	@Autowired
	private ClassTypeService classTypeService;
	
	// 獲取課程清單
	@GetMapping
	public ResponseEntity<ApiResponse<List<ClassTypeDTO>>> getAllClassTypeRoom(){
		return ResponseEntity.ok(ApiResponse.success("獲取課程清單成功", classTypeService.getAllClassTypes()));
	}
	
	// 取得特定課程類型
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<ClassTypeDTO>> getClassType(@PathVariable Long id) {
	    Optional<ClassTypeDTO> optClassTypeDTO = classTypeService.findClassTypeById(id);
	    if (optClassTypeDTO.isEmpty()) {
	        return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此課程類型"));
	    }
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", optClassTypeDTO.get()));
	}
	
	// 取得課程登入活動
	@GetMapping("/list/{id}")
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getActivityScheduleListByClassType(@PathVariable Long id){
		return ResponseEntity.ok(ApiResponse.success("查詢成功", classTypeService.findActivityScheduleByClassType(id)));
	}
	
	
	
	// 新增課程類型
	@PostMapping
	public ResponseEntity<ApiResponse<ClassTypeDTO>> addClassType(@RequestBody ClassTypeDTO classTypeDTO) {
	    ClassTypeDTO newClassTypeDTO = classTypeService.saveClassType(classTypeDTO);
	    return ResponseEntity.ok(ApiResponse.success("新增成功", newClassTypeDTO));
	}

	// 修改課程類型
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ClassTypeDTO>> updateClassType(@PathVariable Long id, @RequestBody ClassTypeDTO classTypeDTO) {
	    ClassTypeDTO updatedClassTypeDTO = classTypeService.updateClassType(classTypeDTO, id);
	    return ResponseEntity.ok(ApiResponse.success("修改成功", updatedClassTypeDTO));
	}

	// 刪除課程類型
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteClassType(@PathVariable Long id) {
	    classTypeService.deleteClassType(id);
	    return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
	
}
