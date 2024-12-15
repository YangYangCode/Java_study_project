package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.service.ActivityManagerService;

@Service
public class ActivityManagerServiceImpl implements ActivityManagerService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ActivityManagerRepository activityManagerRepository;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;

	@Override	// 查詢所有管理員
	public List<ActivityManagerDTO> getAllActivityManagers() {
		return activityManagerRepository.findAll().stream()
				.map(activityManager -> modelMapper.map(activityManager ,ActivityManagerDTO.class))				
				.collect(Collectors.toList());
	}

	@Override	// 查詢指定管理員
	public Optional<ActivityManagerDTO> findActivityManagerById(Long id) {
	    Optional<ActivityManager> optActivityManager = activityManagerRepository.findById(id);
	    if (optActivityManager.isEmpty()) {
	        return Optional.empty();
	    }
	    return Optional.of(modelMapper.map(optActivityManager.get(), ActivityManagerDTO.class));
	}
	
	

	@Override	// 新增管理員
	public ActivityManagerDTO saveActivityManager(ActivityManagerDTO activityManagerDTO) {
		// DTO -> entity
		ActivityManager activityManager = modelMapper.map(activityManagerDTO, ActivityManager.class);
		activityManagerRepository.save(activityManager);
		// return entity -> DTO
		return modelMapper.map(activityManager, ActivityManagerDTO.class);
	}

	@Override	// 修改管理員
	public ActivityManagerDTO updateActivityManager(ActivityManagerDTO activityManagerDTO, Long id) {
		// 使用 id 找到 entity
		ActivityManager activityManager = activityManagerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", id)));
		// 將 DTO 數值修改進 entity
		modelMapper.map(activityManagerDTO, activityManager);
		activityManagerRepository.save(activityManager);
		return modelMapper.map(activityManager, ActivityManagerDTO.class);
	}

	@Override	// 刪除管理員
	public void deleteActivityManager(Long id) {
		// 使用 id 找到 entity
		ActivityManager activityManager = activityManagerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", id)));
		activityManagerRepository.deleteById(id);
	}

	@Override	// 管理員底下所有活動
	public List<ActivityScheduleDTO> findActivityScheduleByActivityManager(Long activityManagerId) {
		// 使用 id 找到 entity
		ActivityManager activityManager = activityManagerRepository.findById(activityManagerId)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", activityManagerId)));
		// AM -> AMASList
		List<ActivityScheduleDTO> AMASList=  activityManager.getActivitySchedules().stream()
			.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
			.collect(Collectors.toList());
		return AMASList;
	}

}
