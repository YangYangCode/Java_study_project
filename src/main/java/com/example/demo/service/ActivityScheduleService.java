package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;

// 活動CRDU邏輯
public interface ActivityScheduleService {
	// 取得所有活動		all active	
	List<ActivityScheduleDTO> getAllActivitySchedules();
	
	// 取得單一活動		a active
	// 取得活動詳細內容	active info
	Optional<ActivityScheduleDTO> getActivityScheduleById(Long activityScheduleId);
	
	// 新增活動
	ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO);
	
	// 修改活動
	ActivityScheduleDTO upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO, Long activityScheduleId);
	
	// 刪除活動
	void deleteActivitySchedule(Long activityScheduleId);
	
	// 新增參加成員
	void addMember(Long activityScheduleId, Long memberId);
	
	// 取得
	
	// 取得參加成員列表
	List<MemberDTO> findMemberListByActivitySchedule(Long activityScheduleId);

}


// 根據活動新增人員取得活動		// 放AS_mamager
//List<ActivityScheduleDTO> findActivityScheduleByActivityManager(Long activityManagerId);
	
// 根據指導教練取得活動		// 放fint
//List<ActivityScheduleDTO> findActivityScheduleByFitnessInstructor(Long fitnessInstructorId);

// 根據課程類型取得活動		// 放classtype
//List<ActivityScheduleDTO> findActivityScheduleByClassType(Long classTypeId);

// 根據教室取得活動			// 放classroom
//List<ActivityScheduleDTO> findActivityScheduleByClassRoom(Long classRoomId);


// 根據 時間區段 取得活動 ? - 用條件篩選得到
