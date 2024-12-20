package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.MemberDTO;

// 使用者帳號密碼管理
public interface AuthService {
	
	// 使用者登入
	Optional<MemberDTO> memberLogin(String username, String password);
	Optional<FitnessInstructorDTO> fitnLogin(String username, String password);
	Optional<ActivityManagerDTO> managerLogin(String username, String password);
	
	// 創立使用者
	
	// 修改密碼
	

}
