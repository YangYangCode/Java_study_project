package com.example.demo.model.entity;

import java.util.Date;
import java.util.Objects;

import com.example.demo.model.BookingForm;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity	// 時間排表
public class FitnessInstructorBookingForm extends BookingForm {
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonManagedReference	// 管理方
	private FitnessInstructor fitnessInstructor;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FitnessInstructorBookingForm other = (FitnessInstructorBookingForm) obj;
		return Objects.equals(fitnessInstructor, other.fitnessInstructor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(fitnessInstructor);
		return result;
	}
	
	@Override
	public String toString() {
		return "FitnessInstructorBookingForm []";
	}
	
	
	
}
