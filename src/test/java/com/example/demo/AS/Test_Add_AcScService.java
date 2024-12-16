package com.example.demo.AS;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.service.ActivityManagerService;
import com.example.demo.service.ActivityScheduleService;
import com.example.demo.service.ClassRoomService;
import com.example.demo.service.ClassTypeService;
import com.example.demo.service.FitnessInstructorService;
import com.example.demo.service.MemberService;

@SpringBootTest
public class Test_Add_AcScService {

	@Autowired
	ModelMapper modelMapper;

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

//	@Test
//	void addActivitySchedules() {
//	    // 假設你已經有活動管理員、教室、課程類型、教練等資料在資料庫中
//	    List<ActivityManagerDTO> activityManagerDTOs = activityManagerService.getAllActivityManagers();
//	    List<ClassRoomDTO> classRoomDTOs = classRoomService.getAllClassRooms();
//	    List<ClassTypeDTO> classTypeDTOs = classTypeService.getAllClassTypes();
//	    List<FitnessInstructorDTO> fitnessInstructorDTOs = fitnessInstructorService.getAllFitnessInstructors();
//
//	    for (int i = 1; i <= 10; i++) {
//	        ActivityScheduleDTO activityScheduleDTO = new ActivityScheduleDTO();
//	        
//	        // 動態設置活動日期和時間
//	        activityScheduleDTO.setDate(new Date()); // 假設是當前日期
//	        activityScheduleDTO.setClassTime("10:00 AM"); // 設置固定的時間
//	        activityScheduleDTO.setMaxSignNumber(30); // 假設每個活動最大報名數量為 30
//	        activityScheduleDTO.setInformation("活動" + i + "的詳細資訊。"); // 動態生成活動詳細信息
//	        
//	        // 隨機選擇 ActivityManager, ClassRoom, ClassType 和 FitnessInstructor
//	        activityScheduleDTO.setActivityManager(activityManagerDTOs.get(i % activityManagerDTOs.size()));
//	        activityScheduleDTO.setClassRoom(classRoomDTOs.get(i % classRoomDTOs.size()));
//	        activityScheduleDTO.setClassType(classTypeDTOs.get(i % classTypeDTOs.size()));
//	        
//	     // 随机选择多个 FitnessInstructors
//	        Set<FitnessInstructorDTO> selectedInstructors = new HashSet<>();
//	        int numInstructorsToSelect = 3;  // 假设你想选择3个教练，可以根据需要调整
//
//	        // 随机选择多个教练，确保不重复
//	        Random random = new Random();
//	        while (selectedInstructors.size() < numInstructorsToSelect) {
//	            selectedInstructors.add(fitnessInstructorDTOs.get(random.nextInt(fitnessInstructorDTOs.size())));
//	        }
//
//	        // 将 selectedInstructors 转换为 Map<Long, String>，Long 是 id，String 是 name
//	        Map<Long, String> instructorMap = selectedInstructors.stream()
//	                .collect(Collectors.toMap(FitnessInstructorDTO::getId, FitnessInstructorDTO::getName));
//
//	        // 设置到 activityScheduleDTO
//	        activityScheduleDTO.setFitnessInstructors(instructorMap);
//
//
//	        activityScheduleService.saveActivitySchedule(activityScheduleDTO);
//	    }
//	}

	@Test
	void addActivitySchedules() {
		// 假設你已經有活動管理員、教室、課程類型、教練等資料在資料庫中
		List<ActivityManagerDTO> activityManagerDTOs = activityManagerService.getAllActivityManagers();
		List<ClassRoomDTO> classRoomDTOs = classRoomService.getAllClassRooms();
		List<ClassTypeDTO> classTypeDTOs = classTypeService.getAllClassTypes();
		List<FitnessInstructorDTO> fitnessInstructorDTOs = fitnessInstructorService.getAllFitnessInstructors();

		// 固定生成 30 個活動
		for (int i = 1; i <= 30; i++) {
			ActivityScheduleDTO activityScheduleDTO = new ActivityScheduleDTO();

			// 隨機選擇活動日期 16 號到 22 號之間
			Random random = new Random();
			int dayOfMonth = random.nextInt(7) + 16;  // 隨機選擇 16 到 22 號
	        LocalDate activityDate = LocalDate.of(2024, 12, dayOfMonth); // 使用 LocalDate 設置日期 (只包含年月日)
			activityScheduleDTO.setDate(activityDate);

			activityScheduleDTO.setClassTime("10:00 AM"); // 設置固定的時間
			activityScheduleDTO.setMaxSignNumber(30); // 假設每個活動最大報名數量為 30
			activityScheduleDTO.setInformation("活動" + i + "的詳細資訊。"); // 動態生成活動詳細信息

			// 隨機選擇 ActivityManager, ClassRoom, ClassType 和 FitnessInstructor
			activityScheduleDTO.setActivityManager(activityManagerDTOs.get(i % activityManagerDTOs.size()));
			activityScheduleDTO.setClassRoom(classRoomDTOs.get(i % classRoomDTOs.size()));
			activityScheduleDTO.setClassType(classTypeDTOs.get(i % classTypeDTOs.size()));

			// 隨機選擇多個 FitnessInstructors
			Set<FitnessInstructorDTO> selectedInstructors = new HashSet<>();
			int numInstructorsToSelect = 3; // 假設選擇 3 個教練

			// 隨機選擇多個教練，確保不重複
			while (selectedInstructors.size() < numInstructorsToSelect) {
				selectedInstructors.add(fitnessInstructorDTOs.get(random.nextInt(fitnessInstructorDTOs.size())));
			}

			// 將 selectedInstructors 轉換為 Map<Long, String>
			Map<Long, String> instructorMap = selectedInstructors.stream()
					.collect(Collectors.toMap(FitnessInstructorDTO::getId, FitnessInstructorDTO::getName));

			// 設置到 activityScheduleDTO
			activityScheduleDTO.setFitnessInstructors(instructorMap);

			// 保存活動時間表
			activityScheduleService.saveActivitySchedule(activityScheduleDTO);
		}
	}

}
