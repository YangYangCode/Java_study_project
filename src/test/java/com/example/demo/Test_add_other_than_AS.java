package com.example.demo;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityManagerRepository;
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
public class Test_add_other_than_AS {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Autowired
	ClassTypeRepository classTypeRepository;
	
	@Autowired
	FitnessInstructorRepository fitnessInstructorRepository;
	
	@Autowired
	ActivityManagerRepository activityManagerRepository;
	
	@Autowired
	MemberRepository memberRepository;
	
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
	
	@Test
	void addClassRooms() {
	    for (int i = 1; i <= 10; i++) {
	        ClassRoom classRoom = new ClassRoom();
	        classRoom.setName("教室" + i); // 動態生成教室名稱，例如 教室1, 教室2...
	        classRoom.setClassRoomSize(20 + i); // 動態生成教室大小，例如 21, 22...
	        classRoomRepository.save(classRoom);
	    }
	}
	

	@Test
	void addClassTypes() {
	    for (int i = 1; i <= 10; i++) {
	        ClassType classType = new ClassType();
	        classType.setName("課程" + i); // 動態生成課程名稱，例如 課程1, 課程2...
	        classTypeRepository.save(classType);
	    }
	}
	

	@Test
	void addFitnessInstructors() {
	    for (int i = 1; i <= 10; i++) {
	        FitnessInstructor fitnessInstructor = new FitnessInstructor();
	        fitnessInstructor.setName("教練" + i); // 動態生成名稱，例如 教練1, 教練2...
	        fitnessInstructor.setUsername("fitn" + i); // 動態生成用戶名，例如 fitn1, fitn2...
	        fitnessInstructor.setPassword("1234"); // 統一密碼
	        fitnessInstructorRepository.save(fitnessInstructor);
	    }
	}

	
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
	

	@Test
	void addMembers() {
	    for (int i = 1; i <= 10; i++) {
	        Member member = new Member();
	        member.setName("會員" + i); // 動態生成名稱，例如 會員1, 會員2...
	        member.setUsername("member" + i); // 動態生成用戶名，例如 member1, member2...
	        member.setPassword("1234"); // 統一密碼
	        memberRepository.save(member);
	    }
	}
	
	

	
}

	

