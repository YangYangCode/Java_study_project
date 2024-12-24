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
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.dto.user.LoginRequest;
import com.example.demo.model.dto.user.UserCret;
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
	public ResponseEntity<ApiResponse<UserCret>> login(@RequestBody LoginRequest request, HttpSession session) {
//		System.out.println("username: "+request.getUsername());
//		System.out.println("password: "+request.getPassword());
//		System.out.println("type: "+request.getType());
		
		UserCret userCret = new UserCret();
		
		switch (request.getType()) {
		case "member":
			Optional<MemberDTO> optMemberDTO = authService.memberLogin(request.getUsername(), request.getPassword());
			if (optMemberDTO.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			
			userCret.setId(optMemberDTO.get().getId());
			userCret.setType(request.getType());
			
			session.setAttribute("userCret", userCret);
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		case "fitnessInstructor":
			Optional<FitnessInstructorDTO> optFitnessInstructor = authService.fitnLogin(request.getUsername(), request.getPassword());
			if (optFitnessInstructor.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			
			userCret.setId(optFitnessInstructor.get().getId());
			userCret.setType(request.getType());
			
			session.setAttribute("userCret", userCret);
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		case "activityManager":
			Optional<ActivityManagerDTO> optActivityManager = authService.managerLogin(request.getUsername(), request.getPassword());
			if (optActivityManager.isEmpty()) {
				return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
			}
			
			userCret.setId(optActivityManager.get().getId());
			userCret.setType(request.getType());
			
			session.setAttribute("userCret", userCret);
			return ResponseEntity.ok(ApiResponse.success("登入成功", null));

		}
		return ResponseEntity.status(404).body(ApiResponse.error(404, "登入失敗"));
	}

	@GetMapping("/logout")
	public ResponseEntity<ApiResponse<String>> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok(ApiResponse.success("登出結果", "登出成功"));
	}
	
	@GetMapping("/isLoggedIn")
	public ResponseEntity<ApiResponse<UserCret>> isLoggedIn(HttpSession session){
		UserCret userCret = (UserCret)session.getAttribute("userCret");
		if(userCret == null) {
			UserCret falseUserCret = new UserCret();
			falseUserCret.setIsLoggedIn(false);
			return ResponseEntity.ok(ApiResponse.success("無登入資訊", falseUserCret));
		}
		userCret.setIsLoggedIn(true);
		return ResponseEntity.ok(ApiResponse.success("用戶已登入", userCret));
	}

	
}
