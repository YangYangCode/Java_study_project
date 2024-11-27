package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
