package com.example.demo.AS;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ActivityManagerService;
import com.example.demo.service.ActivityScheduleService;
import com.example.demo.service.ClassRoomService;
import com.example.demo.service.ClassTypeService;
import com.example.demo.service.FitnessInstructorService;
import com.example.demo.service.MemberService;

@SpringBootTest
public class Test_Add_AcScService {

	@Autowired
	ActivityManagerService activityManagerService;
	
	@Autowired
	ClassRoomService classRoomService;
	
	@Autowired
	ClassTypeService classTypeService;
	
	@Autowired
	FitnessInstructorService fitnessInstructorService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	ActivityScheduleService activityScheduleService;
	
	@Test	// AM
	void add_AM() {
		ActivityManagerDTO AM_1 = new ActivityManagerDTO();
		AM_1.setName("陳Manager");
		AM_1.setUsername("manager");
		AM_1.setPassword("1234");
		activityManagerService.saveActivityManager(AM_1);
	}
	
	@Test	//Room
	void add_Room() {
		ClassRoomDTO classRoom_1 = new ClassRoomDTO();
		classRoom_1.setName("101");
		classRoom_1.setClassRoomSize(20);
		classRoomService.saveClassRoom(classRoom_1);
	}
	
	@Test
	void add_class() {
		ClassTypeDTO classType_1 = new ClassTypeDTO();
		classType_1.setName("瑜珈");
		classTypeService.saveClassType(classType_1);
	}
	
	@Test
	void add_fitn() {
		FitnessInstructorDTO fitnessInstructor_1 = new FitnessInstructorDTO();
		fitnessInstructor_1.setName("王教練");
		fitnessInstructor_1.setUsername("fitn");
		fitnessInstructor_1.setPassword("1234");
		fitnessInstructorService.saveFitnessInstructor(fitnessInstructor_1);
	}
	
	@Test
	void add_member() {
		MemberDTO member_1 = new MemberDTO();
		member_1.setName("李會員");
		member_1.setUsername("member");
		member_1.setPassword("1234");
		memberService.saveMember(member_1);
	}
	
	@Test
	void add_AS() {
		ActivityScheduleDTO AS_1 = new ActivityScheduleDTO();
		
		AS_1.setDate(java.sql.Date.valueOf("2024-12-30"));
		AS_1.setClassTime("11:00-12:00");
		AS_1.setMaxSignNumber(20);
		
		AS_1.setInformation("asp;lkmjnbawsertyuiolkmnbv");
		
		ActivityManagerDTO AM_1 = new ActivityManagerDTO();
		AM_1.setId(1L);
		AM_1.setName("陳Manager");
		AM_1.setUsername("manager");
		AM_1.setPassword("1234");
		AS_1.setActivityManager(AM_1);
		
		ClassRoomDTO classRoom_1 = new ClassRoomDTO();
		classRoom_1.setId(1L);
		classRoom_1.setName("101");
		classRoom_1.setClassRoomSize(20);
		AS_1.setClassRoom(classRoom_1);
		
		ClassTypeDTO classType_1 = new ClassTypeDTO();
		classType_1.setId(1L);
		classType_1.setName("瑜珈");
		AS_1.setClassType(classType_1);
		
		Map<Long, String> map = new HashMap<>();
		map.put(1L, "王教練");
		AS_1.setFitnessInstructors(map);
		
		
		activityScheduleService.saveActivitySchedule(AS_1);
		
	}
	
	
	
}
