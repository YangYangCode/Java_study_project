package com.example.demo.model.entity;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FitnessInstructor extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;		// *教練邊號
	
	@Column(nullable = false)
	private String name;		// 教練姓名
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fitnesslnstructor_booking_form_id")
	private FitnesslnstructorBookingForm fitnesslnstructorBookingForm;		// 預約表
	
	@ManyToMany(mappedBy = "fitnessInstructors", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private Set<ActivitySchedule> activitySchedules; 
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="fitness_instructor_activity_schedule", joinColumns = @JoinColumn(name= "fitness_instructor_id"))
//	@Column(name = "activity_schedule_id")
//	private Set<Long> activityScheduleIds; 		
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
	@JsonManagedReference	// 管理方
	private Set<ClassType> classTypes; 	// 可帶課程類型
//	@JoinTable(inverseJoinColumns = @JoinColumn(name = "class_type_id"))
//	@ElementCollection(fetch = FetchType.EAGER)
//	@CollectionTable(name="fitness_instructor_class_type", joinColumns = @JoinColumn(name= "fitness_instructor_id"))
//	@MapKeyColumn(name = "class_type_id")
//	@Column(name = "class_type_name")
//	private Map<Long, String> classTypes; 	// 可帶課程類型

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FitnessInstructor other = (FitnessInstructor) obj;
		return Objects.equals(classTypes, other.classTypes) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(classTypes, id, name);
		return result;
	}
	
	
	
}
