package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.BookingFormDTO;

// 統一預約表邏輯
public interface BookingFormService {
	// (先取得類型 instanceof) 再CRDU
	
	// 查詢
	List<BookingFormDTO> getAllBookings(Object type);		
	
	// 新增
	void saveBooking(Object type, BookingFormDTO bookingFormDTO);
	
	// 修改，刪除
	void upDateBooking(Object type, BookingFormDTO bookingFormDTO, Long id);
	
	
}
