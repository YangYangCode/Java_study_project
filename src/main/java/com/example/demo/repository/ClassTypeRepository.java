package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassType;

@Repository		// 課程項目
public interface ClassTypeRepository extends JpaRepository<ClassType, Long> {

	
}
