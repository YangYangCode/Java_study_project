package com.example.demo.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.dto.BookingFormDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberDTO extends UserCretDTO {
	private Long id;	// *會員邊號
	private String name;	// 會員名稱
	
	private Set<ActivityScheduleDTO> activitySchedules; // 參加的活動
	private BookingFormDTO BookingForm;
}
