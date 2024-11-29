package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ActivityManager;

@Repository		// 活動管理員
public interface ActivityManagerRepository extends JpaRepository<ActivityManager, Long> {

}
