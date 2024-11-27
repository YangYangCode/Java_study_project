package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.ActivitySchedule;


public interface ActivityScheduleRepository extends JpaRepository<ActivitySchedule, Long> {

}
