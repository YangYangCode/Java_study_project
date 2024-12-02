package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;

// 活動CRDU邏輯
public interface ActivityScheduleService {
	// 取得所有活動		all active	
	List<ActivityScheduleDTO> findAllActivitySchedules();
	
	// 取得單一活動		a active
	// 取得活動詳細內容	active info
	Optional<ActivityScheduleDTO> getActivityScheduleById(Long ActivityScheduleId);
	
	// 新增活動
	ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO);
	
	// 修改活動
	ActivityScheduleDTO upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO, Long ActivityScheduleId);
	
	// 刪除活動
	ActivityScheduleDTO deleteActivitySchedule(Long ActivityScheduleId);
	
	// 根據活動新增人員取得活動
	List<ActivityScheduleDTO> findActivityScheduleByActivityManager(Long ActivityManagerId);
		
	// 根據指導教練取得活動
	List<ActivityScheduleDTO> findActivityScheduleByFitnessInstructor(Long FitnessInstructorId);
	
	// 根據課程類型取得活動
	List<ActivityScheduleDTO> findActivityScheduleByClassType(Long ClassTypeId);
	
	// 取得參加成員列表
	List<ActivityScheduleDTO> findMemberListByActivitySchedule(Long ActivityScheduleId, MemberDTO members);
	
	
	// 根據 時間區段 取得活動 ? - 用條件篩選得到
}
