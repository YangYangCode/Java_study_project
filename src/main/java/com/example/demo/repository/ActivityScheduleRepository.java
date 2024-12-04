package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ActivitySchedule;

@Repository		// 活動
public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Long> {

//	List<ActivitySchedule> findByClassRoomId(Long classRoomId);
//	
//	List<ActivitySchedule> findByFitnessInstructorsId(Long fitnessInstructorId);
//	
//	List<ActivitySchedule> findByClassTypeId(Long ClassTypeId);
//	
//	List<ActivitySchedule> findByActivityManagerId(Long activityManagerId);
}
