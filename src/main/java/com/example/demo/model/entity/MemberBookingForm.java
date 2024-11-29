package com.example.demo.model.entity;

import java.util.Date;

import com.example.demo.model.BookingForm;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity	// 時間排表
public class MemberBookingForm extends BookingForm {
	
	@OneToOne(mappedBy = "memberBookingForm")
	private Member member;
}
