package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ActivitySchedule;

import jakarta.transaction.Transactional;

@Repository		// 活動
public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM activity_schedule_fitness_instructors WHERE activity_schedule_id = :activityScheduleId", nativeQuery = true)
	void deleteASId_allFitnId(@Param("activityScheduleId") Long activityScheduleId);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM member_activity_schedules WHERE activity_schedule_id = :activityScheduleId", nativeQuery = true)
	void deleteASId_allMemberId(@Param("activityScheduleId") Long activityScheduleId);

}
