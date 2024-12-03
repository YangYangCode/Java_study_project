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

	@Override
	public List<ActivityManagerDTO> getAllActivityManagers() {
		return activityManagerRepository.findAll().stream()
				.map(activityManager -> modelMapper.map(activityManager ,ActivityManagerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ActivityManagerDTO> findActivityManagerById(Long id) {
		// 使用 id 找到 entity
		Optional<ActivityManager> optactivityManager = activityManagerRepository.findById(id);
		if(optactivityManager.isEmpty()) {
			return Optional.empty();
		}
		// 利用modelMapper 將 optactivityManager 轉 ActivityManagerDTO
		return Optional.of(modelMapper.map(optactivityManager.get(), ActivityManagerDTO.class));
	}

	@Override
	public ActivityManagerDTO saveActivityManager(ActivityManagerDTO activityManagerDTO) {
		// DTO -> entity
		ActivityManager activityManager = modelMapper.map(activityManagerDTO, ActivityManager.class);
		activityManagerRepository.save(activityManager);
		// return entity -> DTO
		return modelMapper.map(activityManager, ActivityManagerDTO.class);
	}

	@Override
	public ActivityManagerDTO updateActivityManager(ActivityManagerDTO activityManagerDTO, Long id) {
		// 使用 id 找到 entity
		ActivityManager activityManager = activityManagerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", id)));
		// 將 DTO 數值修改進 entity
		modelMapper.map(activityManagerDTO, activityManager);
		activityManagerRepository.save(activityManager);
		return modelMapper.map(activityManager, ActivityManagerDTO.class);
	}

	@Override
	public void deleteActivityManager(Long id) {
		// 使用 id 找到 entity
		ActivityManager activityManager = activityManagerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManager, id: %d 不存在。", id)));
		activityManagerRepository.deleteById(id);
		
	}

}
