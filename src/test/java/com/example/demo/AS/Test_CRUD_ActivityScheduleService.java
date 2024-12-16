package com.example.demo.AS;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.service.ActivityScheduleService;


@SpringBootTest
public class Test_CRUD_ActivityScheduleService {

	@Autowired
	ActivityScheduleService activityScheduleService;

	@Test
	void mix() {
	    ActivityScheduleDTO activitySchedule = new ActivityScheduleDTO();
	    String add_ClassTime;
	    String update_ClassTime;
	    
	    // add
//	    activitySchedule.setDate(java.sql.Date.valueOf("2024-12-30"));
	    activitySchedule.setClassTime("11:00-12:00");
	    activitySchedule.setMaxSignNumber(20);
		
	    activitySchedule.setInformation("asp;lkmjnbawsertyuiolkmnbv");
		
		ActivityManagerDTO AM_1 = new ActivityManagerDTO();
		AM_1.setId(1L);
		AM_1.setName("陳Manager");
		AM_1.setUsername("manager");
		AM_1.setPassword("1234");
		activitySchedule.setActivityManager(AM_1);
		
		ClassRoomDTO classRoom_1 = new ClassRoomDTO();
		classRoom_1.setId(1L);
		classRoom_1.setName("101");
		classRoom_1.setClassRoomSize(20);
		activitySchedule.setClassRoom(classRoom_1);
		
		ClassTypeDTO classType_1 = new ClassTypeDTO();
		classType_1.setId(1L);
		classType_1.setName("瑜珈");
		activitySchedule.setClassType(classType_1);
		
		Map<Long, String> map = new HashMap<>();
		map.put(1L, "王教練");
		activitySchedule.setFitnessInstructors(map);
		
		activitySchedule = activityScheduleService.saveActivitySchedule(activitySchedule);
		add_ClassTime = activitySchedule.getClassTime();
	    
	    // getId
	    Long activityScheduleId = activitySchedule.getId();
	    
	    // find
	    Optional<ActivityScheduleDTO> find = activityScheduleService.findActivityScheduleById(activityScheduleId);
	    
//		System.out.println(find.getClassRoom().getClass());
	    
	    // update
	    activitySchedule.setClassTime("08:00 - 9:30");
	    activityScheduleService.updateActivitySchedule(activitySchedule, activityScheduleId);
	    update_ClassTime = activitySchedule.getClassTime();
	    
	    // delete
	    activityScheduleService.deleteActivitySchedule(activityScheduleId);
	    
	    if(find != null) { 
	        System.out.println("find ok");
	    }
	    System.out.println(add_ClassTime);
	    System.out.println(update_ClassTime);
	}
	
}