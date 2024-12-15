package com.example.demo.Manager;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.service.ActivityManagerService;

@SpringBootTest
public class Test_findAll_ActivityManagerService {

	@Autowired
	ActivityManagerRepository activityManagerRepository;
	
	@Autowired
	ActivityManagerService activityManagerService;
	
	@Test
	void findAll() {
		List<ActivityManagerDTO> allAM =  activityManagerService.getAllActivityManagers();
		System.out.println(allAM);
		
	}
	
}
