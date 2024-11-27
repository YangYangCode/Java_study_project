package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.ClassRoomBookingForm;

public interface ClassRoomBookingFormRepository extends JpaRepository<ClassRoomBookingForm, Long> {

}
