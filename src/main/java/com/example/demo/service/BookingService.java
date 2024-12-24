package com.example.demo.service;

import java.time.LocalDate;

import com.example.demo.model.dto.booking.ListOfBooking;
import com.example.demo.model.dto.booking.OneOfBooking;

public interface BookingService {
	
	// get all booking list
	public ListOfBooking getListOfBooking(ListOfBooking listOfBooking);
	
	
	// 新增booking
	public OneOfBooking addBooking(OneOfBooking oneOfBooking);
	
	// 取消booking
	public void cancelBooking(OneOfBooking oneOfBooking);

//	// switch
//	private String intToString(int number);
//	private int stringToInt(String timePeriod);
	
	
}
