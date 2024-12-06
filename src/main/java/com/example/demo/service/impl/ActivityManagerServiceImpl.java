package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.service.ActivityManagerService;

@Service
public class ActivityManagerServiceImpl implements ActivityManagerService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ActivityManagerRepository activityManagerRepository;

	@Override	// 查詢所有管理員
	public List<ActivityManagerDTO> getAllActivityManagers() {
		return activityManagerRepository.findAll().stream()
				.map(activityManager -> modelMapper.map(activityManager ,ActivityManagerDTO.class))
				.collect(Collectors.toList());
	}

	@Override // 找到活動管理員 by id
	public ActivityManagerDTO findActivityManagerById(Long id) {
	    ActivityManager activityManager = activityManagerRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", id)));
	    // 使用 ModelMapper 將 Entity 映射為 DTO
	    return modelMapper.map(activityManager, ActivityManagerDTO.class);
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

}
