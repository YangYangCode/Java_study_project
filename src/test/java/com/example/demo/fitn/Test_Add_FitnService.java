package com.example.demo.fitn;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.FitnessInstructorRepository;

@SpringBootTest
public class Test_Add_FitnService {

	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
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
	
	
}
