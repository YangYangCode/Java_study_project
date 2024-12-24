package com.example.demo.repository.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassRoomBookingForm;
import com.example.demo.model.entity.FitnessInstructorBookingForm;

import jakarta.transaction.Transactional;

@Repository		// 教練預約表
public interface FitnesslnstructorBookingFormRepository extends JpaRepository<FitnessInstructorBookingForm, Long> {

	@Query(value = "SELECT * FROM fitness_instructor_booking_form WHERE date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<FitnessInstructorBookingForm> getBookingsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
	
}
