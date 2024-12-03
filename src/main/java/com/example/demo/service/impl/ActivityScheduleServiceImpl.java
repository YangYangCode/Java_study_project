package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.service.ActivityScheduleService;

@Service
public class ActivityScheduleServiceImpl implements ActivityScheduleService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;

	@Override
	public List<ActivityScheduleDTO> getAllActivitySchedules() {
		return activityScheduleRepository.findAll().stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ActivityScheduleDTO> getActivityScheduleById(Long activityScheduleId) {
		Optional<ActivitySchedule> optActivitySchedule = activityScheduleRepository.findById(activityScheduleId);
		if(optActivitySchedule.isEmpty()) {
			return Optional.empty();
		}
		// modelMapper, entity -> DTO
		return Optional.of(modelMapper.map(optActivitySchedule.get(), ActivityScheduleDTO.class));
		
	}

	@Override
	public ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO) {
		// DTO -> entity
		ActivitySchedule activitySchedule = modelMapper.map(activityScheduleDTO, ActivitySchedule.class);
		activityScheduleRepository.save(activitySchedule);
		// return entity -> DTO
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	@Override
	public ActivityScheduleDTO upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO,Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// 將 DTO 數值修改近 entity
		modelMapper.map(activityScheduleDTO, activitySchedule);
		activityScheduleRepository.save(activitySchedule);
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	@Override
	public void deleteActivitySchedule(Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		activityScheduleRepository.deleteById(activityScheduleId);
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByActivityManager(Long activityManagerId) {
		return activityScheduleRepository.findByActivityManagerId(activityManagerId).stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByFitnessInstructor(Long fitnessInstructorId) {
		return activityScheduleRepository.findByFitnessInstructorsId(fitnessInstructorId).stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByClassType(Long classTypeId) {
		return activityScheduleRepository.findByClassTypeId(classTypeId).stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByClassRoom(Long classRoomId) {
		return activityScheduleRepository.findByClassRoomId(classRoomId).stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public void addMember(Long activityScheduleId, MemberDTO memberDTO) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		Set<Member> memberList = activitySchedule.getSignedMemberList();
		memberList.add(modelMapper.map(memberDTO, Member.class));
		activitySchedule.setSignedMemberList(memberList);
		activityScheduleRepository.save(activitySchedule);
	}

	@Override
	public List<MemberDTO> findMemberListByActivitySchedule(Long activityScheduleId) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		List<MemberDTO> memberList = activitySchedule.getSignedMemberList().stream()
			.map(member -> modelMapper.map(member, MemberDTO.class))
			.collect(Collectors.toList());
		return memberList;
	}
	
	
	

}
