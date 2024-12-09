package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.MemberService;

/**
 * WEB API
 * ------------------------------------------
 * servlet-path: /member (@RequestMapping)
 * ------------------------------------------
 * GET    "/"     獲取所有會員	(X
 * GET    "/{id}" 獲取該會員
 * GET	  "/{id}" 獲取會員登入活動
 * POST   "/"     新增會員
 * PUT    "/{id}" 更新會員
 * DELETE "/{id}" 刪除會員
 * ------------------------------------------
 * */

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired 
	private MemberService memberService;
	
	// 獲取特定會員
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<MemberDTO>> getMember(@PathVariable Long id) {
	    Optional<MemberDTO> optMemberDTO = memberService.findMemberById(id);
	    if (optMemberDTO.isEmpty()) {
	        return ResponseEntity.status(404).body(ApiResponse.error(404, "查無此會員"));
	    }
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", optMemberDTO.get()));
	}
	
	// 取得會員參加的活動
	@GetMapping("/{id}/activities")
	public ResponseEntity<ApiResponse<List<ActivityScheduleDTO>>> getActivityScheduleListByMember(@PathVariable Long id) {
	    return ResponseEntity.ok(ApiResponse.success("查詢成功", memberService.findActivityScheduleByMember(id)));
	}

	// 新增會員
	@PostMapping
	public ResponseEntity<ApiResponse<MemberDTO>> addMember(@RequestBody MemberDTO memberDTO) {
	    MemberDTO newMemberDTO = memberService.saveMember(memberDTO);
	    return ResponseEntity.ok(ApiResponse.success("新增成功", newMemberDTO));
	}

	// 修改會員資訊
	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<MemberDTO>> updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
	    MemberDTO updatedMemberDTO = memberService.updateMember(memberDTO, id);
	    return ResponseEntity.ok(ApiResponse.success("修改成功", updatedMemberDTO));
	}

	// 刪除會員
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<Void>> deleteMember(@PathVariable Long id) {
	    memberService.deleteMember(id);
	    return ResponseEntity.ok(ApiResponse.success("刪除成功", null));
	}
	
}
