package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.repository.FitnessInstructorRepository;

@SpringBootTest
public class AddFitnServiceTest {

	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
	@Test
	void add() {
		FitnessInstructor fitnessInstructor_1 = new FitnessInstructor();
		fitnessInstructor_1.setName("一二三");
		fitnessInstructor_1.setUsername("fitn");
		fitnessInstructor_1.setPassword("1234");
		fitnessInstructorRepository.save(fitnessInstructor_1);
	}
	
}
