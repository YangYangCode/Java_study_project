package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
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
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ActivityScheduleService;

@Service
public class ActivityScheduleServiceImpl implements ActivityScheduleService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;
	
	@Autowired
	private MemberRepository memberRepository;

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

	@Override	//要修改
	public ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO) {
		// DTO -> entity
		ActivitySchedule activitySchedule = modelMapper.map(activityScheduleDTO, ActivitySchedule.class);
		activityScheduleRepository.save(activitySchedule);
		// return entity -> DTO
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	@Override	//要修改
	public ActivityScheduleDTO upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO,Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// 將 DTO 數值修改近 entity
		modelMapper.map(activityScheduleDTO, activitySchedule);
		activityScheduleRepository.save(activitySchedule);
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	@Override	//要修改
	public void deleteActivitySchedule(Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		activityScheduleRepository.deleteById(activityScheduleId);
	}

	

	@Override
	public void addMember(Long activityScheduleId, Long memberId, String memberName) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		activitySchedule.getSignedMembers().put(memberId, memberName);
		activityScheduleRepository.save(activitySchedule);
	}

	@Override
	public List<MemberDTO> findMemberListByActivitySchedule(Long activityScheduleId) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		List<MemberDTO> memberList = activitySchedule.getSignedMembers().keySet().stream().map(memberId -> {
				Member member = memberRepository.findById(memberId)	// memberId -> Member entity
					.orElseThrow(() -> new RuntimeException(String.format("Member, id: %d 不存在。", memberId)));
	            return modelMapper.map(member, MemberDTO.class);	// 將 Member 轉換為 MemberDTO
				})
				.collect(Collectors.toList());
		return memberList;
	}
	
	/*
	@Override
	public void addMember(Long activityScheduleId, Long memberId, String memberName) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		Map<Long, String> memberList = activitySchedule.getSignedMembers();	
		memberList.put(memberId, memberName);
		activitySchedule.setSignedMembers(memberList);
		activityScheduleRepository.save(activitySchedule);
	}
	*/

}


/**
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
*/
