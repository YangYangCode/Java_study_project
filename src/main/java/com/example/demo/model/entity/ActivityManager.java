package com.example.demo.model.entity;

import java.util.List;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ActivityManager extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	// 自動生成，從1開始，每次+1，過號不補
	private Long id;		// *邊號
	
	@Column(nullable = false)
	private String name;		// 管理者姓名
	
	@JsonIgnore
	@OneToMany(mappedBy = "activityManager", fetch = FetchType.EAGER)
	@JsonBackReference	// 被管理方
	private List<ActivitySchedule> activitySchedules;
}
