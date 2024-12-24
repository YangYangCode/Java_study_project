package com.example.demo.repository.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassRoomBookingForm;

@Repository		// 教室預約表
public interface ClassRoomBookingFormRepository extends JpaRepository<ClassRoomBookingForm, Long> {

	@Query(value = "SELECT * FROM class_room_booking_form WHERE date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<ClassRoomBookingForm> getBookingsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
//	@Query(value = "SELECT * FROM class_room_booking_form WHERE date BETWEEN :startDate AND :endDate", nativeQuery = true)
//	List<ClassRoomBookingForm> getBookingsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
}
