package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.booking.ListOfBooking;
import com.example.demo.model.dto.booking.OneOfBooking;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:5175", allowCredentials = "true")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	// 預約清單
	@GetMapping("/bookingList")
	public ResponseEntity<ApiResponse<ListOfBooking>> getBookingList(@RequestBody ListOfBooking listOfBooking){
		return ResponseEntity.ok(ApiResponse.success("查詢預約清單成功", bookingService.getListOfBooking(listOfBooking)));
	}
	
	// 新增預約
	@PostMapping("/addBooking")
	public ResponseEntity<ApiResponse<OneOfBooking>> addBooking(@RequestBody OneOfBooking oneOfBooking){
		return ResponseEntity.ok(ApiResponse.success("預約成功", bookingService.addBooking(oneOfBooking)));
	}
	
	// 取消預約
	@DeleteMapping("/cancelBooking")
	public ResponseEntity<ApiResponse<Void>> cancelBooking(@RequestBody OneOfBooking oneOfBooking){
		bookingService.cancelBooking(oneOfBooking);
		return ResponseEntity.ok(ApiResponse.success("取消成功", null));
	}
	
	
	
}
