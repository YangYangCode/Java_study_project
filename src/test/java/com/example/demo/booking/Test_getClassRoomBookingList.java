package com.example.demo.booking;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.booking.ClassRoomBookingFormRepository;

@SpringBootTest
public class Test_getClassRoomBookingList {

	@Autowired
	private ClassRoomBookingFormRepository classRoomBookingFormRepository;
	
    @Autowired
    private ClassRoomRepository classRoomRepository;
	
	@Test
	void getBookingList() {
		
	}
}
