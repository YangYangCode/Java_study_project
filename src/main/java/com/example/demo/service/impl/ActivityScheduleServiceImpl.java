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
import com.example.demo.model.dto.booking.OneOfBooking;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ActivityScheduleService;
import com.example.demo.service.FitnessInstructorService;
import com.example.demo.service.MemberService;

import jakarta.transaction.Transactional;

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
	
	@Autowired
	private BookingServiceImpl bookingServiceImpl;

	
	@Override	// 取得所有活動
	public List<ActivityScheduleDTO> getAllActivitySchedules() {
		return activityScheduleRepository.findAll().stream()
				.map(activitySchedule -> {
	                // 转换 ActivitySchedule 到 DTO
	                ActivityScheduleDTO dto = modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	                // 教练信息转换为 Map 并设置到 DTO 中
	                Map<Long, String> fitnessInstructors = activitySchedule.getFitnessInstructors().stream()
	                        .collect(Collectors.toMap(FitnessInstructor::getId, FitnessInstructor::getName));
	                dto.setFitnessInstructors(fitnessInstructors);
	                // 会员信息转换为 Map 并设置到 DTO 中
	                Map<Long, String> signedMembers = activitySchedule.getSignedMembers().stream()
	                        .collect(Collectors.toMap(Member::getId, Member::getName));
	                dto.setSignedMembers(signedMembers);
	                
	                return dto;
	            })
	            .collect(Collectors.toList());
	}
	
	
	@Override	// 取得單一活動
	public Optional<ActivityScheduleDTO> findActivityScheduleById(Long id) {
	    Optional<ActivitySchedule> optActivitySchedule = activityScheduleRepository.findById(id);
	    if (optActivitySchedule.isEmpty()) {
	        return Optional.empty();
	    }
	    ActivitySchedule activitySchedule = optActivitySchedule.get();
	    // 转换 ActivitySchedule 到 DTO
	    ActivityScheduleDTO dto = modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	    // 教练信息转换为 Map 并设置到 DTO 中
	    Map<Long, String> fitnessInstructors = activitySchedule.getFitnessInstructors().stream()
	            .collect(Collectors.toMap(FitnessInstructor::getId, FitnessInstructor::getName));
	    dto.setFitnessInstructors(fitnessInstructors);
	    // 会员信息转换为 Map 并设置到 DTO 中
	    Map<Long, String> signedMembers = activitySchedule.getSignedMembers().stream()
	            .collect(Collectors.toMap(Member::getId, Member::getName));
	    dto.setSignedMembers(signedMembers);
	    return Optional.of(dto);
	}
	
	
	@Transactional
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
	// fitnessInstructors
		Set<FitnessInstructor> FitnList = activityScheduleDTO.getFitnessInstructors().keySet().stream()
				.map(fitnId -> {FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnId)
								.orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId)));
								return fitnessInstructor;
								})
				.collect(Collectors.toSet());
		activitySchedule.setFitnessInstructors(FitnList);
		
	// 儲存活動
		activitySchedule =  activityScheduleRepository.save(activitySchedule);
		
	// 預約表變更
		// 製作共用 OneOfBooking
		OneOfBooking oneOfBooking = new OneOfBooking();
		oneOfBooking.setDate(activitySchedule.getDate());
		oneOfBooking.setTimePeriod(activitySchedule.getClassTime());
		
		// 教練預約新增
		FitnList.stream().forEach(fitn -> {
			OneOfBooking fitnOfBooking = oneOfBooking;
			fitnOfBooking.setType("fitnessInstructor");
			fitnOfBooking.setTypeId(fitn.getId());
			bookingServiceImpl.addBooking(fitnOfBooking);
		});
		
		// 教室預約新增
		OneOfBooking roomOfBooking = oneOfBooking;
		roomOfBooking.setType("classRoom");
		roomOfBooking.setTypeId(classRoom.getId());
		bookingServiceImpl.addBooking(roomOfBooking);
		
		// return entity -> DTO
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Override	// 更新活動
	public ActivityScheduleDTO updateActivitySchedule(ActivityScheduleDTO activityScheduleDTO,Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		
	// 直接覆蓋
	// 將 DTO 數值修改近 entity
		modelMapper.map(activityScheduleDTO, activitySchedule);
	// classRoom
		ClassRoom classRoom = modelMapper.map(activityScheduleDTO.getClassRoom(), ClassRoom.class);
		activitySchedule.setClassRoom(classRoom);
	// classType
		ClassType classType = modelMapper.map(activityScheduleDTO.getClassType(), ClassType.class);
		activitySchedule.setClassType(classType);
	// activityMamager
		ActivityManager activityManager = modelMapper.map(activityScheduleDTO.getActivityManager(), ActivityManager.class);
		activitySchedule.setActivityManager(activityManager);
	// fitnessInstructors
		Set<FitnessInstructor> FitnList = activityScheduleDTO.getFitnessInstructors().keySet().stream()
				.map(fitnId -> fitnessInstructorRepository.findById(fitnId)
								.orElseThrow(() -> new RuntimeException(String.format("FitnessInstructor, id: %d 不存在。", fitnId))))
				.collect(Collectors.toSet());
		activitySchedule.setFitnessInstructors(FitnList);
		
	// 儲存活動		
		activityScheduleRepository.save(activitySchedule);

	// 預約表變更
		
		return modelMapper.map(activitySchedule, ActivityScheduleDTO.class);
	}

	
	@Transactional
	@Override	// 刪除活動
	public void deleteActivitySchedule(Long activityScheduleId) {
		// 使用 id 找到 entity
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		// 刪除教練關聯
//		activityScheduleRepository.deleteASId_allFitnId(activityScheduleId);
		// 刪除會員關聯
		activityScheduleRepository.deleteASId_allMemberId(activityScheduleId);
		// 刪除活動
		activityScheduleRepository.deleteById(activityScheduleId);
	}
	
	
	@Override	// 取得參與成員列表
	public Map<Long, String> findMemberListByActivitySchedule(Long activityScheduleId) {
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		Map<Long, String> signedMembers = activitySchedule.getSignedMembers().stream()
				.collect(Collectors.toMap(Member::getId, Member::getName));
										// Key: id	   , Value: 名稱						             
		return signedMembers;
	}
	
	
//	@Override
//	public Map<Long, String> addFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId) {
//		// find entity by id
//		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
//				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
//		// add fitnessInstructor
//		activitySchedule.getFitnessInstructors().put(fitnessInstructor.getId(), fitnessInstructor.getName());
//		// save activitySchedule
//		activityScheduleRepository.save(activitySchedule);
//		return activitySchedule.getFitnessInstructors();
//	}
//
//
//	@Override
//	public Map<Long, String> deleteFitnessInstructor(Long activityScheduleId, Long fitnessInstructorId) {
//		// find entity by id
//		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		// delete fitnessInstructor
//		activitySchedule.getFitnessInstructors().remove(fitnessInstructorId);
//		activityScheduleRepository.save(activitySchedule);
//		return activitySchedule.getFitnessInstructors();
//	}
//
//
//	@Override
//	public Map<Long, String> addMember(Long activityScheduleId, Long memberId) {
//		// find entity by id
//		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		Member member = memberRepository.findById(memberId)
//				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
//		// add member
//		activitySchedule.getSignedMembers().put(member.getId(), member.getName());
//		// save activitySchedule
//		activityScheduleRepository.save(activitySchedule);
//		return activitySchedule.getSignedMembers();
//	}
//
//
//	@Override
//	public Map<Long, String> deleteMember(Long activityScheduleId, Long memberId) {
//		// find entity by id
//		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		// delete member
//		activitySchedule.getSignedMembers().remove(memberId);
//		activityScheduleRepository.save(activitySchedule);
//		return activitySchedule.getSignedMembers();
//	}
//	
//
//	private void fitnModify(ActivitySchedule activitySchedule,ActivityScheduleDTO activityScheduleDTO) {
//		// 新舊教練名單
//		Set<Long> oldFint =  activitySchedule.getFitnessInstructors().keySet();
//		Set<Long> newFint =  activityScheduleDTO.getFitnessInstructors().keySet();
//		// 取交集
//		Set<Long> crosses = new HashSet<>(oldFint); // 复制
//		crosses.retainAll(newFint); // 求交集
//		// 去除交集
//		oldFint.removeAll(crosses);
//		newFint.removeAll(crosses);
//		
//		Long activityScheduleId =  activitySchedule.getId();
//		
//		// 修改教練 - 去除
//		if(!oldFint.isEmpty()) {
//			oldFint.forEach(fitnId -> {
//				fitnessInstructorService.deleteActivitySchedule(fitnId, activityScheduleId);
//			});
//		}
//		
//		// 修改教練 - 新增
//		if(!newFint.isEmpty()) {
//			// 教練方新增
//			newFint.forEach(fitnId -> {
//				fitnessInstructorService.addActivitySchedule(fitnId, activityScheduleId);
//			});
//		}
//		
//	}


	
	
	
	
}


