package com.example.demo.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;

// 活動CRDU邏輯
public interface ActivityScheduleService {
	// 取得所有活動		all active	
	List<ActivityScheduleDTO> getAllActivitySchedules();
	
	// 取得單一活動		a active
	// 取得活動詳細內容	active info
	Optional<ActivityScheduleDTO> findActivityScheduleById(Long activityScheduleId);
	
	// 新增活動
	ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO);
	
	// 修改活動
	ActivityScheduleDTO updateActivitySchedule(ActivityScheduleDTO activityScheduleDTO, Long activityScheduleId);
	
	// 刪除活動
	void deleteActivitySchedule(Long activityScheduleId);

	// 取得參加成員列表
	List<MemberDTO> findMemberListByActivitySchedule(Long activityScheduleId);

	
	// 活動新增教練
	Map<Long, String> addFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId);
	
	// 活動刪除教練
	Map<Long, String> deleteFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId);
	
	// 新增活動報名成員
	Map<Long, String> addMember(Long activityScheduleId, Long memberId);
	
	// 刪除活動報名成員
	Map<Long, String> deleteMember(Long activityScheduleId, Long memberId);
	
	
}

// 根據 時間區段 取得活動 ? - 用條件篩選得到
