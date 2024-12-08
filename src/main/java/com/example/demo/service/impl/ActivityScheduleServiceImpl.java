package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Information;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ActivityScheduleService;
import com.example.demo.service.FitnessInstructorService;
import com.example.demo.service.MemberService;

@Service
public class ActivityScheduleServiceImpl implements ActivityScheduleService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
	@Autowired
	private FitnessInstructorService fitnessInstructorService;

	
	@Override	// 取得所有活動
	public List<ActivityScheduleDTO> getAllActivitySchedules() {
		return activityScheduleRepository.findAll().stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public Optional<ActivityScheduleDTO> findActivityScheduleById(Long id) {
	    Optional<ActivitySchedule> optActivitySchedule = activityScheduleRepository.findById(id);
	    if (optActivitySchedule.isEmpty()) {
	        return Optional.empty();
	    }
	    // 利用 modelMapper 將 ActivitySchedule 轉 ActivityScheduleDTO
	    return Optional.of(modelMapper.map(optActivitySchedule.get(), ActivityScheduleDTO.class));
	}

	
	@Override	// 新增活動
	public ActivityScheduleDTO saveActivitySchedule(ActivityScheduleDTO activityScheduleDTO) {	
		// DTO -> entity
		ActivitySchedule activitySchedule = modelMapper.map(activityScheduleDTO, ActivitySchedule.class);
		
	// classRoom
		ClassRoom classRoom = modelMapper.map(activityScheduleDTO.getClassRoom(), ClassRoom.class);
		activitySchedule.setClassRoom(classRoom);
	// classType
		ClassType classType = modelMapper.map(activityScheduleDTO.getClassType(), ClassType.class);
		activitySchedule.setClassType(classType);
	// activityMamager
		ActivityManager activityManager = modelMapper.map(activityScheduleDTO.getActivityManager(), ActivityManager.class);
		activitySchedule.setActivityManager(activityManager);
	// info
		Information information = modelMapper.map(activityScheduleDTO.getInformation(), Information.class);
		activitySchedule.setInformation(information);
	// 教練表
		activitySchedule.setFitnessInstructors(activityScheduleDTO.getFitnessInstructors());
	// 成員表
		activitySchedule.setSignedMembers(activityScheduleDTO.getSignedMembers());
		
		// 儲存活動
		activitySchedule =  activityScheduleRepository.save(activitySchedule);
		// 取得最新活動 id
		Long activityScheduleId = activitySchedule.getId();
		
	// 連動更新
		// 教練方新增
		activityScheduleDTO.getFitnessInstructors().keySet().forEach(fitnId -> {
			fitnessInstructorService.addActivitySchedule(fitnId, activityScheduleId);
		});

	// 預約表變更
		
		// return entity -> DTO
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Override	// 更新活動
	public ActivityScheduleDTO updateActivitySchedule(ActivityScheduleDTO activityScheduleDTO,Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		
		// 直接覆蓋
		// classRoom
		ClassRoom classRoom = modelMapper.map(activityScheduleDTO.getClassRoom(), ClassRoom.class);
		activitySchedule.setClassRoom(classRoom);
		// classType
		ClassType classType = modelMapper.map(activityScheduleDTO.getClassType(), ClassType.class);
		activitySchedule.setClassType(classType);
		// FitnessInstructors	
		activitySchedule.setFitnessInstructors(activityScheduleDTO.getFitnessInstructors());
		// info
		Information information = modelMapper.map(activityScheduleDTO.getInformation(), Information.class);
		activitySchedule.setInformation(information);
		
		// 教練人員更改
		fitnModify(activitySchedule, activityScheduleDTO);
		
		// 儲存活動
		activityScheduleRepository.save(activitySchedule);
		
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Override	// 刪除活動
	public void deleteActivitySchedule(Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		
		// FitnessInstructors 教練方修改 - 刪除活動資訊
		activitySchedule.getFitnessInstructors().keySet().forEach(fitnId -> {
			fitnessInstructorService.deleteActivitySchedule(fitnId, activityScheduleId);
		});
		
		// signedMembers 會員方修改 - 刪除活動資訊
		activitySchedule.getSignedMembers().keySet().forEach(memberId -> {
			memberService.deleteActivitySchedule(memberId, activityScheduleId);
		});
		
		// 預約表變更
		
		activityScheduleRepository.deleteById(activityScheduleId);
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


	@Override
	public Map<Long, String> addFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId) {
		// find entity by id
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
		// add fitnessInstructor
		activitySchedule.getFitnessInstructors().put(fitnessInstructor.getId(), fitnessInstructor.getName());
		// save activitySchedule
		activityScheduleRepository.save(activitySchedule);
		return activitySchedule.getFitnessInstructors();
	}


	@Override
	public Map<Long, String> deleteFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId) {
		// find entity by id
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// delete fitnessInstructor
		activitySchedule.getFitnessInstructors().remove(fitnessInstructorId);
		activityScheduleRepository.save(activitySchedule);
		return activitySchedule.getFitnessInstructors();
	}


	@Override
	public Map<Long, String> addMember(Long activityScheduleId, Long memberId) {
		// find entity by id
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
		// add member
		activitySchedule.getSignedMembers().put(member.getId(), member.getName());
		// save activitySchedule
		activityScheduleRepository.save(activitySchedule);
		return activitySchedule.getSignedMembers();
	}


	@Override
	public Map<Long, String> deleteMember(Long activityScheduleId, Long memberId) {
		// find entity by id
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// delete member
		activitySchedule.getSignedMembers().remove(memberId);
		activityScheduleRepository.save(activitySchedule);
		return activitySchedule.getSignedMembers();
	}
	

	private void fitnModify(ActivitySchedule activitySchedule,ActivityScheduleDTO activityScheduleDTO) {
		// 新舊教練名單
		Set<Long> oldFint =  activitySchedule.getFitnessInstructors().keySet();
		Set<Long> newFint =  activityScheduleDTO.getFitnessInstructors().keySet();
		// 取交集
		Set<Long> crosses = new HashSet<>(oldFint); // 复制
		crosses.retainAll(newFint); // 求交集
		// 去除交集
		oldFint.removeAll(crosses);
		newFint.removeAll(crosses);
		
		Long activityScheduleId =  activitySchedule.getId();
		
		// 修改教練 - 去除
		if(!oldFint.isEmpty()) {
			oldFint.forEach(fitnId -> {
				fitnessInstructorService.deleteActivitySchedule(fitnId, activityScheduleId);
			});
		}
		
		// 修改教練 - 新增
		if(!newFint.isEmpty()) {
			// 教練方新增
			newFint.forEach(fitnId -> {
				fitnessInstructorService.addActivitySchedule(fitnId, activityScheduleId);
			});
		}
		
	}
	
	
	
}


