package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ActivitySchedule;

@Repository		// 活動
public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Long> {

	List<ActivitySchedule> findByClassRoom(String classRoom);
	
	List<ActivitySchedule> findByFitnessInstructor(Long id);
	
	List<ActivitySchedule> findByClassType(Long id);
}
