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
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;
	
	
	@Override
	public List<MemberDTO> getAllMembers() {
		return memberRepository.findAll().stream()
				.map(member -> modelMapper.map(member, MemberDTO.class))
				.collect(Collectors.toList());		
	}
	
	@Override	// 找到指定會員
	public Optional<MemberDTO> findMemberById(Long id) {
	    Optional<Member> optMember = memberRepository.findById(id);
	    if (optMember.isEmpty()) {
	        return Optional.empty();
	    }
	    // 利用 modelMapper 將 Member 轉 MemberDTO
	    return Optional.of(modelMapper.map(optMember.get(), MemberDTO.class));
	}
	
	@Override	// 新增會員
	public MemberDTO saveMember(MemberDTO memberDTO) {
		// DTO -> entity
		Member member = modelMapper.map(memberDTO, Member.class);
		memberRepository.save(member);
		// return entity -> DTO
		return modelMapper.map(member, MemberDTO.class);
		
	}

	@Override	// 修改會員
	public MemberDTO updateMember(MemberDTO memberDTO, Long id) {
		// 使用 id 找到 entity
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", id)));
		// 將 DTO 數值修改進 entity
		modelMapper.map(memberDTO, member);
		memberRepository.save(member);
		return modelMapper.map(member, MemberDTO.class);
	}

	@Override	// 刪除會員
	public void deleteMember(Long id) {
		// 使用 id 找到 entity
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", id)));
		memberRepository.deleteById(id);
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByMember(Long memberId) {
	    // find entity by id
	    Member member = memberRepository.findById(memberId)
	            .orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
	    // member -> memberASList
	    List<ActivityScheduleDTO> ASList = member.getActivitySchedules().stream()
	    		.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
	    return ASList;
	}

	
	@Override
	public void signActivitySchedule(Long memberId, Long activityScheduleId) {
		// find entity by id
	    Member member = memberRepository.findById(memberId)
	            .orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
	    ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
	    member.getActivitySchedules().add(activitySchedule);
	    memberRepository.save(member);
//	    return findActivityScheduleByMember(memberId);
	}

	@Override
	public void cancelActivitySchedule(Long memberId, Long activityScheduleId) {
		memberRepository.deleteSignAS(memberId, activityScheduleId);
		
//		// find entity by id
//	    Member member = memberRepository.findById(memberId)
//	            .orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
//	    ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//	    member.getActivitySchedules().
//	    remove(activitySchedule);
////	    member.setActivitySchedules(member.getActivitySchedules().remove(activitySchedule));
////	    activityScheduleRepository.save(activitySchedule);
	    
//	    memberRepository.save(member);

	    
	}
	
	
	
}
