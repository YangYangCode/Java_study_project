package com.example.demo.fitn;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.service.FitnessInstructorService;

@SpringBootTest
public class Test_CRUD_FitnService {

	@Autowired
	FitnessInstructorService fitnessInstructorService;
	
	@Test
	void mix() {
		FitnessInstructorDTO fitnessInstructor = new FitnessInstructorDTO();
		String add_Name;
		String update_Name;
		
		// add
		fitnessInstructor.setName("新教練");
		fitnessInstructor = fitnessInstructorService.saveFitnessInstructor(fitnessInstructor);
		add_Name = fitnessInstructor.getName();
		
		// getId
		Long fitnessInstructorId = fitnessInstructor.getId();
		
		// find
		Optional<FitnessInstructorDTO> find =  fitnessInstructorService.findFitnessInstructorById(fitnessInstructorId);
		
		// update
		fitnessInstructor.setName("更新教練");
		fitnessInstructorService.updateFitnessInstructor(fitnessInstructor, fitnessInstructorId);
		update_Name = fitnessInstructor.getName();
		
		// delete
		fitnessInstructorService.deleteFitnessInstructor(fitnessInstructorId);
		
		if(find != null) {System.out.println("find ok");}
		System.out.println(add_Name);
		System.out.println(update_Name);
		
	}


}
