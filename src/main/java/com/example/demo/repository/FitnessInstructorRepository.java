package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.FitnessInstructor;

import jakarta.transaction.Transactional;

@Repository		// 教練
public interface FitnessInstructorRepository extends JpaRepository<FitnessInstructor, Long> {

	Optional<FitnessInstructor> findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM activity_schedule_fitness_instructors WHERE fitness_instructor_id = :fitnessInstructorId", nativeQuery = true)
	void deleteFitnId_allASId(@Param("fitnessInstructorId") Long fitnessInstructorId);
	

}
