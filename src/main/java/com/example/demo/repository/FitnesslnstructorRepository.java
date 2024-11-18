package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.FitnessInstructor;

@Repository
public interface FitnesslnstructorRepository extends JpaRepository<FitnessInstructor, Long>{

}
