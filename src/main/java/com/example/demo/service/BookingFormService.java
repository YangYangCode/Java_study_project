package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.BookingFormDTO;

// 統一預約表邏輯
public interface BookingFormService {
	// (先取得類型 instanceof) 再CRDU
	
	// 查詢
	List<BookingFormDTO> findAllBookings();		// 放 type ?	
	
	// 新增
	Optional<BookingFormDTO> addBooking(BookingFormDTO bookingFormDTO);
	
	// 修改，刪除
	Optional<BookingFormDTO> upDateBooking(BookingFormDTO bookingFormDTO, Long id);
	
	
}
