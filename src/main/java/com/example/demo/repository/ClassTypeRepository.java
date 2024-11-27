package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.ClassType;

public interface ClassTypeRepository extends JpaRepository<ClassType, Long> {

}
