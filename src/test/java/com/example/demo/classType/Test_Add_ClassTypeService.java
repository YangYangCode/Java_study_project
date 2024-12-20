package com.example.demo.classType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassType;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.service.ClassTypeService;

@SpringBootTest
public class Test_Add_ClassTypeService {

	@Autowired
	ClassTypeRepository classTypeRepository;
	
	@Autowired
	ClassTypeService classTypeService;
	
	@Test
	void addClassTypes() {
//	    for (int i = 1; i <= 10; i++) {
//	        ClassType classType = new ClassType();
//	        classType.setName("課程" + i); // 動態生成課程名稱，例如 課程1, 課程2...
//	        classTypeRepository.save(classType);
		// 使用 id 找到 entity
		ClassType classType = classTypeRepository.findById(1L)
				.orElseThrow(() -> new RuntimeException(String.format("classType, id: %d 不存在。", 1L)));
		
		
		System.out.println(classType.getActivitySchedules());
	    }
	}
	

