package com.example.demo.service;

import java.util.List;
import java.util.Optional;


import com.example.demo.model.dto.ActivityScheduleDTO;

import com.example.demo.model.dto.MemberDTO;

public interface MemberService {
	// 取得所有會員
	List<MemberDTO> getAllMembers();

	// 查詢單一會員
	Optional<MemberDTO> findMemberById(Long id);
	
	// 新增會員
	MemberDTO saveMember(MemberDTO memberDTO);
	
	// 修改會員
	MemberDTO updateMember(MemberDTO memberDTO, Long id);
	
	// 刪除會員
	void deleteMember(Long id);
	
	// 根據會員獲取活動
	List<ActivityScheduleDTO> findActivityScheduleByMember(Long memberId); 
	
	// 報名活動
	void signActivitySchedule(Long memberId, Long activityScheduleId);
	
	// 取消報名
	void cancelActivitySchedule(Long memberId, Long activityScheduleId);
	
	
//	// 新增活動
//	Set<Long> addActivitySchedule(Long memberId, Long activityScheduleId);
//	
//	// 刪除活動
//	Set<Long> deleteActivitySchedule(Long memberId, Long activityScheduleId);
	

	
	
	// 查詢單一會員Booking		// 在BookingForm
	
}


