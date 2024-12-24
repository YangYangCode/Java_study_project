package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassRoom;

import jakarta.transaction.Transactional;

@Repository		// 教室
public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {

//	@Transactional
//	@Modifying
//	@Query(value = "DELETE FROM member_activity_schedules WHERE signed_members_id = :memberId AND activity_schedule_id = :activityScheduleId", nativeQuery = true)
//	void getBookingsByDateRange(@Param("") Long startDate, @Param("") Long endDate);
//	
	
}
