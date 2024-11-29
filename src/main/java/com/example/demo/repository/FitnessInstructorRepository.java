package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.FitnessInstructor;

@Repository		// 教練
public interface FitnessInstructorRepository extends JpaRepository<FitnessInstructor, Long> {

	Optional<FitnessInstructor> findByClassType(Long Id);

}
