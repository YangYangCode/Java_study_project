package com.example.demo.booking;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.booking.ListOfBooking;
import com.example.demo.model.dto.booking.OneOfBooking;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassRoomBookingForm;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.booking.ClassRoomBookingFormRepository;
import com.example.demo.service.BookingService;

@SpringBootTest
public class Test_classRoom_addBooking {

	@Autowired
	private ClassRoomBookingFormRepository classRoomBookingFormRepository;

	@Autowired
	private BookingService bookingService;

//	@Test
	void testAddBooking() {
		OneOfBooking oneOfBooking = new OneOfBooking();
		oneOfBooking.setType("classRoom");
		oneOfBooking.setTypeId(2L);
		oneOfBooking.setDate(LocalDate.of(2024, 12, 17));
		oneOfBooking.setTimePeriod("9:00-12:00");

		OneOfBooking result = bookingService.addBooking(oneOfBooking);
		System.out.println(oneOfBooking.getBookingId());

		// 驗證資料庫是否包含該預約
		Optional<ClassRoomBookingForm> booking = classRoomBookingFormRepository.findById(oneOfBooking.getTypeId());
		Assertions.assertTrue(booking.isPresent(), "資料庫應該包含該預約");
	}

	@Test
	void testCancelBooking() {
		OneOfBooking oneOfBooking = new OneOfBooking();
		oneOfBooking.setType("classRoom");
		oneOfBooking.setTypeId(2L);
		oneOfBooking.setDate(LocalDate.of(2024, 12, 17));
		oneOfBooking.setTimePeriod("9:00-12:00");

		// 先新增一個預約
		bookingService.addBooking(oneOfBooking);

		oneOfBooking.setBookingId(3L);		// 指定刪除編號
		
		// 取消預約
		bookingService.cancelBooking(oneOfBooking);

		// 驗證資料庫不包含該預約
		Optional<ClassRoomBookingForm> booking = classRoomBookingFormRepository.findById(oneOfBooking.getBookingId());
		Assertions.assertFalse(booking.isPresent(), "預約應該被取消");
	}
	
	
//	@Test
	void testGetRoomBookingList() {
		ListOfBooking listOfBooking = new ListOfBooking();
		listOfBooking.setType("classRoom");
		listOfBooking.setId(2L);
		listOfBooking.setStartDate(LocalDate.of(2024, 12, 17));
		listOfBooking.setEndDate(LocalDate.of(2024, 12, 29));
		listOfBooking = bookingService.getListOfBooking(listOfBooking);
		System.out.println(listOfBooking);
	}
	
	
}
