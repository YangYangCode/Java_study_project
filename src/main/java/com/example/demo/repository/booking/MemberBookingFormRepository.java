package com.example.demo.repository.booking;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.MemberBookingForm;

@Repository		// 會員預約表
public interface MemberBookingFormRepository extends JpaRepository<MemberBookingForm, Long> {
	
	@Query(value = "SELECT * FROM member_booking_form WHERE date BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<MemberBookingForm> getBookingsByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
