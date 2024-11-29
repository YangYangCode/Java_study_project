package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Equipment;

@Repository		// 器材
public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
