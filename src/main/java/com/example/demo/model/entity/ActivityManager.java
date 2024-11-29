package com.example.demo.model.entity;

import java.util.List;

import com.example.demo.model.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "activitySchedule_id")
	private List<ActivitySchedule> activitySchedules;
}
