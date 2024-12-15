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
	void addActivityManagers() {
	    for (int i = 1; i <= 10; i++) {
	        ActivityManager activityManager = new ActivityManager();
	        activityManager.setName("管理員" + i); // 動態生成名稱，例如 管理員1, 管理員2...
	        activityManager.setUsername("manager" + i); // 動態生成用戶名，例如 manager1, manager2...
	        activityManager.setPassword("1234"); // 統一密碼
	        activityManagerRepository.save(activityManager);
	    }
	}
	
	
}
