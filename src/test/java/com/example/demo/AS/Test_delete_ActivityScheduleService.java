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
public class Test_delete_ActivityScheduleService {

	@Autowired
	ActivityScheduleService activityScheduleService;

	@Test
	void mix() {
	    
	    // delete
	    activityScheduleService.deleteActivitySchedule(6L);
	    
	    
	}
	
}