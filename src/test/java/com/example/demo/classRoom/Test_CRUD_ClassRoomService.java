package com.example.demo.classRoom;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.service.ClassRoomService;

@SpringBootTest
public class Test_CRUD_ClassRoomService {

	@Autowired
	ClassRoomService classRoomService;
	
	@Test
	void mix() {
		ClassRoomDTO classRoom = new ClassRoomDTO();
		Integer add_number;
		Integer update_number;
		
		// add
		classRoom.setName("test");
		classRoom.setClassRoomSize(50);
		classRoom = classRoomService.saveClassRoom(classRoom);
		add_number = classRoom.getClassRoomSize();
		
		// getId
		Long classRoomId = classRoom.getId();
		
		// find
		Optional<ClassRoomDTO> find =  classRoomService.findClassRoomById(classRoomId);
		
		// update
		classRoom.setClassRoomSize(15);
		classRoomService.updateClassRoom(classRoom, classRoomId);
		update_number = classRoom.getClassRoomSize();
		
		// delete
		classRoomService.deleteClassRoom(classRoomId);
		
		if(find != null) {System.out.println("find ok");}
		System.out.println(add_number);
		System.out.println(update_number);
		
	}


}
