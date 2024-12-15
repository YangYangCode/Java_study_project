package com.example.demo.classRoom;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;

@SpringBootTest
public class Test_Add_ClassRoomService {

	@Autowired
	ClassRoomRepository classRoomRepository;
	
	@Test
	void addClassRooms() {
	    for (int i = 1; i <= 10; i++) {
	        ClassRoom classRoom = new ClassRoom();
	        classRoom.setName("教室" + i); // 動態生成教室名稱，例如 教室1, 教室2...
	        classRoom.setClassRoomSize(20 + i); // 動態生成教室大小，例如 21, 22...
	        classRoomRepository.save(classRoom);
	    }
	}
	
}
