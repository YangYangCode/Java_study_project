package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ActivityManagerDTO;

// 活動管理員CRDU
public interface ActivityManagerService {
	// 查詢所有管理員
	List<ActivityManagerDTO> getAllActivityManagers();
	
	// 查詢單一管理員
	Optional<ActivityManagerDTO> findActivityManagerById(Long id);
	
	// 新增管理員
	ActivityManagerDTO saveActivityManager(ActivityManagerDTO activityManagerDTO);
	
	// 修改管理員
	ActivityManagerDTO updateActivityManager(ActivityManagerDTO activityManagerDTO, Long id);
	
	// 刪除管理員
	void deleteActivityManager(Long id);
	
	
}