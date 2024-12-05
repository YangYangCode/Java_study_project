package com.example.demo.service;

import java.util.Optional;

import com.example.demo.model.dto.MemberDTO;

public interface MemberService {
	// 新增會員
	MemberDTO saveMember(MemberDTO memberDTO);
	
	// 修改會員
	MemberDTO updateMember(MemberDTO memberDTO, Long id);
	
	// 刪除會員
	void deleteMember(Long id);
	
	// 新增活動
	
	// 刪除活動
	
	// 查詢單一會員Booking		// 在BookingForm
	
}


