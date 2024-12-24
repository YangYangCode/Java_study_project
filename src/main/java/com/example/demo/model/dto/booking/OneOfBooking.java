package com.example.demo.model.dto.booking;

import java.time.LocalDate;

import lombok.Data;

@Data
public class OneOfBooking {
	
	private String type;		// 類型
	private Long typeId;		// 物件編號
	
	private Long bookingId;		// 預約編號
	private LocalDate date;		// 日期
	private String timePeriod;	// 時段


}
