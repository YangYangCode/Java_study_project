package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.entity.MemberBookingForm;

public interface MemberBookingFormRepository extends JpaRepository<MemberBookingForm, Long> {

}
