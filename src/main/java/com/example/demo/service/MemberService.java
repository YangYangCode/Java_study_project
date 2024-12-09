package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;

public interface MemberService {
	// 查詢單一會員
	Optional<MemberDTO> findMemberById(Long id);
	
	// 新增會員
	MemberDTO saveMember(MemberDTO memberDTO);
	
	// 修改會員
	MemberDTO updateMember(MemberDTO memberDTO, Long id);
	
	// 刪除會員
	void deleteMember(Long id);
	
	// 新增活動
	Set<Long> addActivitySchedule(Long memberId, Long activityScheduleId);
	
	// 刪除活動
	Set<Long> deleteActivitySchedule(Long memberId, Long activityScheduleId);
	
	// 根據會員獲取活動
	List<ActivityScheduleDTO> findActivityScheduleByMember(Long MemberId); 
	
	
	// 查詢單一會員Booking		// 在BookingForm
	
}


