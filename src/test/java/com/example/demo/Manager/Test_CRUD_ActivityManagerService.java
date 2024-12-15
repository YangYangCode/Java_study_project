package com.example.demo.Manager;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.service.ActivityManagerService;


@SpringBootTest
public class Test_CRUD_ActivityManagerService {

	@Autowired
	ActivityManagerService activityManagerService;
	
	@Test
	void mix() {
		ActivityManagerDTO activityManager = new ActivityManagerDTO();
		String add_Name;
		String update_Name;
		
		// add
		activityManager.setName("新管理員");
		activityManager = activityManagerService.saveActivityManager(activityManager);
		add_Name = activityManager.getName();
		
		// getId
		Long activityManagerId = activityManager.getId();
		
		// find
		Optional<ActivityManagerDTO>  find =  activityManagerService.findActivityManagerById(activityManagerId);
		
		// update
		activityManager.setName("更新管理員");
		activityManagerService.updateActivityManager(activityManager, activityManagerId);
		update_Name = activityManager.getName();
		
		// delete
		activityManagerService.deleteActivityManager(activityManagerId);
		
		if(find != null) {System.out.println("find ok");}
		System.out.println(add_Name);
		System.out.println(update_Name);
		
	}


}
