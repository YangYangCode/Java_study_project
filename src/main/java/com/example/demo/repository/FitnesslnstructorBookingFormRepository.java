package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.FitnesslnstructorBookingForm;

@Repository
public interface FitnesslnstructorBookingFormRepository extends JpaRepository<FitnesslnstructorBookingForm, Long> {

}
