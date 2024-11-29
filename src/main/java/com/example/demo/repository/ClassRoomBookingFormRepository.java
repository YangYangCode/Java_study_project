package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassRoomBookingForm;

@Repository
public interface ClassRoomBookingFormRepository extends JpaRepository<ClassRoomBookingForm, Long> {

}
