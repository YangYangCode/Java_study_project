package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.MemberDTO;

public interface MemberService {
	// 查詢單一會員Booking
	// 在BookingForm
	
	// 新增會員
	void addMember(MemberDTO memberDTO);
	
	// 修改會員
	void Member(MemberDTO memberDTO, Long id);
	
	// 刪除會員
	void deleteMember(Long id);
	
}


