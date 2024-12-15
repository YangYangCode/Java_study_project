package com.example.demo.classType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassType;
import com.example.demo.repository.ClassTypeRepository;

@SpringBootTest
public class Test_Add_ClassTypeService {

	@Autowired
	ClassTypeRepository classTypeRepository;
	
	@Test
	void addClassTypes() {
	    for (int i = 1; i <= 10; i++) {
	        ClassType classType = new ClassType();
	        classType.setName("課程" + i); // 動態生成課程名稱，例如 課程1, 課程2...
	        classTypeRepository.save(classType);
	    }
	}
	
}
