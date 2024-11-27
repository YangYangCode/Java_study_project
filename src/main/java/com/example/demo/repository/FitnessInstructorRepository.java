package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.FitnessInstructor;

public interface FitnessInstructorRepository extends JpaRepository<FitnessInstructor, Long> {

}
