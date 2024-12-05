package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;

@SpringBootTest
public class AddClassRoomServiceTest {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Test
	void add() {
		ClassRoom classRoom_1 = new ClassRoom();
		classRoom_1.setName("101");
		classRoom_1.setClassRoomSize(20);
//		classRoom_1.setClassTypes(null);
		classRoomRepository.save(classRoom_1);
	}
	
}
