package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.service.ActivityScheduleService;

public class ActivityScheduleServiceImpl implements ActivityScheduleService{

	@Override
	public List<ActivityScheduleDTO> findAllActivitySchedules() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<ActivityScheduleDTO> getActivityScheduleById(Long ActivityScheduleId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO, Long ActivityScheduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteActivitySchedule(Long ActivityScheduleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByActivityManager(Long ActivityManagerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByFitnessInstructor(Long FitnessInstructorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByClassType(Long ClassTypeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MemberDTO> findMemberListByActivitySchedule(Long ActivityScheduleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
