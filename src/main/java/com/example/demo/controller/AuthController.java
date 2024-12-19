package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.LoginRequest;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.dto.UserCretDTO;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.AuthService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<UserCretDTO>> login(@RequestBody LoginRequest request, HttpSession session) {
		switch (type) {
		case "member":
			Optional<MemberDTO> optMemberDTO = authService.memberLogin(username, password);
			if (optMemberDTO.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			session.setAttribute("memberDTO", optMemberDTO.get());
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		case "fitnessInstructors":
			Optional<FitnessInstructorDTO> optFitnessInstructor = authService.fitnLogin(username, password);
			if (optFitnessInstructor.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			session.setAttribute("memberDTO", optFitnessInstructor.get());
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		case "activityManager":
			Optional<ActivityManagerDTO> optActivityManager = authService.managerLogin(username, password);
			if (optActivityManager.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			session.setAttribute("memberDTO", optActivityManager.get());
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		}
		return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
	}

	@GetMapping("/logout")
	public ResponseEntity<ApiResponse<String>> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok(ApiResponse.success("登出結果", "登出成功"));
	}

	
}
