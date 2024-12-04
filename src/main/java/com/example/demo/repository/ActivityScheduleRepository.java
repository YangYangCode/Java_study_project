package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ActivitySchedule;

@Repository		// 活動
public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Long> {

}
