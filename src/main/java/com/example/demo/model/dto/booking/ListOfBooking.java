package com.example.demo.model.dto.booking;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class ListOfBooking {

	private String type;		 // 類型
	private Long id;			 // 人員編號
	private LocalDate startDate; // 開始日起 
	private LocalDate endDate;	 // 結束日期
	
	private Map<Long ,Map<LocalDate, Map<String, Long>>> allBooking;
		//	   typeId		預約日期		 預約時段	bookingId
	
	
}
