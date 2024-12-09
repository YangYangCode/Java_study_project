package com.example.demo.Manager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ActivityManager;
import com.example.demo.repository.ActivityManagerRepository;

@SpringBootTest
public class Test_Add_ActivityManagerService {

	@Autowired
	ActivityManagerRepository activityManagerRepository;
	
	@Test
	void add() {
		ActivityManager AM_1 = new ActivityManager();
		AM_1.setName("陳Manager");
		AM_1.setUsername("manager");
		AM_1.setPassword("1234");
		activityManagerRepository.save(AM_1);
	}
	
}
