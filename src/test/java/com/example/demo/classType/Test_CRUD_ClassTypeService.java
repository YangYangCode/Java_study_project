package com.example.demo.classType;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.service.ClassTypeService;

@SpringBootTest
public class Test_CRUD_ClassTypeService {

	@Autowired
	ClassTypeService classTypeService;
	
	@Test
	void mix() {
		ClassTypeDTO classType = new ClassTypeDTO();
		String add_Name;
		String update_Name;
		
		// add
		classType.setName("有氧");
		classType = classTypeService.saveClassType(classType);
		add_Name = classType.getName();
		
		// getId
		Long classTypeId = classType.getId();
		
		// find
		Optional<ClassTypeDTO> find =  classTypeService.findClassTypeById(classTypeId);
		
		// update
		classType.setName("飛輪");
		classTypeService.updateClassType(classType, classTypeId);
		update_Name = classType.getName();
		
		// delete
		classTypeService.deleteClassType(classTypeId);
		
		if(find != null) {System.out.println("find ok");}
		System.out.println(add_Name);
		System.out.println(update_Name);
		
	}


}
