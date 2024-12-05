package com.example.demo.service.impl;

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

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Information;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.FitnessInstructorRepository;
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
	
	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;

	
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
		
		/*
		// AM List新增此活動	// 有mappingBy，不需儲存
		Long activityManageId = activityScheduleDTO.getActivityManagerId();
		ActivityManager activityManager = activityManagerRepository.findById(activityManageId)
				.orElseThrow(() -> new RuntimeException(String.format("ActivityManage, id: %d 不存在。", activityManageId)));
		activityManager.getActivitySchedules().add(activitySchedule);
		// AM 更新儲存
		activityManagerRepository.save(activityManager);
		 */
		
	// classRoom
		ClassRoom classRoom = modelMapper.map(activityScheduleDTO.getClassRoom(), ClassRoom.class);
		activitySchedule.setClassRoom(classRoom);
	// classType
		ClassType classType = modelMapper.map(activityScheduleDTO.getClassType(), ClassType.class);
		activitySchedule.setClassType(classType);
	// FitnessInstructors	
		activitySchedule.setFitnessInstructors(activityScheduleDTO.getFitnessInstructors());
	// info
		Information information = new Information();
		information.setInfo(activityScheduleDTO.getInformation());	// information(entity) set DTO 中的資料
		activitySchedule.setInformation(information);
		
		// 儲存活動
		activitySchedule =  activityScheduleRepository.save(activitySchedule);
		// 取得最新活動 id
		Long activityScheduleId = activitySchedule.getId();
		
	// 連動更新
		// 教練方新增
		activityScheduleDTO.getFitnessInstructors().keySet().forEach(fitnId -> {
			// fitnId -> fitn entity
			FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnId)
			        .orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId)));
			// fitn entity add activityId
			fitnessInstructor.getActivityScheduleIds().add(activityScheduleId);
//			fitnessInstructor.setActivityScheduleIds(activityScheduleIds);
		    fitnessInstructorRepository.save(fitnessInstructor);
		});
		
		// 會員方新增	// 建立新活動時沒有參與會員
		
		// 預約表變更
		
		// return entity -> DTO
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Override	
	public ActivityScheduleDTO upDateActivitySchedule(ActivityScheduleDTO activityScheduleDTO,Long activityScheduleId) {
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
		Information information = new Information();
		information.setInfo(activityScheduleDTO.getInformation());	// information(entity) set DTO 中的資料
		activitySchedule.setInformation(information);
		
		// 教練更改
		// 新舊教練名單
		Set<Long> oldFint =  activitySchedule.getFitnessInstructors().keySet();
		Set<Long> newFint =  activityScheduleDTO.getFitnessInstructors().keySet();
		// 取交集
		Set<Long> crosses = new HashSet<>(oldFint); // 复制
		crosses.retainAll(newFint); // 求交集
		// 去除交集
		oldFint.removeAll(crosses);
		newFint.removeAll(crosses);
		
		// 修改教練 - 去除
		if(!oldFint.isEmpty()) {
			// 教練方刪除
			oldFint.forEach(fitnId -> {
				// fitnId -> fitn entity
				FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnId)
				        .orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId)));
				// fitn entity delete activityId
				fitnessInstructor.getActivityScheduleIds().remove(activityScheduleId);
//				fitnessInstructor.setActivityScheduleIds(activityScheduleIds);
			    fitnessInstructorRepository.save(fitnessInstructor);
			});
		}
		
		// 修改教練 - 新增
		if(!newFint.isEmpty()) {
			// 教練方新增
			newFint.forEach(fitnId -> {
				// fitnId -> fitn entity
				FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnId)
				        .orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId)));
				// fitn entity add activityId
				fitnessInstructor.getActivityScheduleIds().add(activityScheduleId);
//				fitnessInstructor.setActivityScheduleIds(activityScheduleIds);
			    fitnessInstructorRepository.save(fitnessInstructor);
			});
		}
		
		// 儲存活動
		activityScheduleRepository.save(activitySchedule);
		
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Override
	public void deleteActivitySchedule(Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// FitnessInstructors 教練方修改 - 刪除活動資訊
		Set<Long> fintIds =  activitySchedule.getFitnessInstructors().keySet();
		fintIds.forEach(fitnId -> {
			// fitnId -> fitn entity
			FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnId)
			        .orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId)));
			// fitn entity delete activityId
			fitnessInstructor.getActivityScheduleIds().remove(activityScheduleId);
//			fitnessInstructor.setActivityScheduleIds(activityScheduleIds);
		    fitnessInstructorRepository.save(fitnessInstructor);
		});
		
		// signedMembers 會員方修改 - 刪除活動資訊
		Set<Long> memberIds =  activitySchedule.getSignedMembers().keySet();
		memberIds.forEach(memberId -> {
			// memberId -> member entity
			Member member = memberRepository.findById(memberId)
					.orElseThrow(() -> new RuntimeException(String.format("Member, id: %d 不存在。", memberId)));
			// member entity delete activityId
			member.getActivityScheduleIds().remove(activityScheduleId);
			memberRepository.save(member);
		});
		
		// 預約表變更
		
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


	@Override
	public Map<Long, String> addFitnessInstructor(Long fitnessInstructorId, Long activityScheduleId) {
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
	public Map<Long, String> deleteFitnessInstructor(Long fitnessInstructorId, Long activityScheduleId) {
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
	

}


/**
@Override
public void addMember(Long activityScheduleId, Long memberId, String memberName) {
	ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
			.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
	Map<Long, String> memberList = activitySchedule.getSignedMembers();	
	memberList.put(memberId, memberName);
	activitySchedule.setSignedMembers(memberList);
	activityScheduleRepository.save(activitySchedule);
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
*/
