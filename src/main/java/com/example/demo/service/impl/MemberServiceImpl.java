package com.example.demo.service.impl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	// 查詢單一會員
	public MemberDTO findMemberById(Long id) {
	    Member member = memberRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException(String.format("Member, id: %d 不存在。", id)));
	    // 使用 ModelMapper 將 Entity 映射為 DTO
	    return modelMapper.map(member, MemberDTO.class);
	}	
	
	@Override
	public MemberDTO saveMember(MemberDTO memberDTO) {
		// DTO -> entity
		Member member = modelMapper.map(memberDTO, Member.class);
		memberRepository.save(member);
		// return entity -> DTO
		return modelMapper.map(member, MemberDTO.class);
		
	}

	@Override
	public MemberDTO updateMember(MemberDTO memberDTO, Long id) {
		// 使用 id 找到 entity
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", id)));
		// 將 DTO 數值修改進 entity
		modelMapper.map(memberDTO, member);
		memberRepository.save(member);
		return modelMapper.map(member, MemberDTO.class);
	}

	@Override
	public void deleteMember(Long id) {
		// 使用 id 找到 entity
		Member member = memberRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", id)));
		memberRepository.deleteById(id);
		
	}

	@Override
	public Set<Long> addActivitySchedule(Long memberId, Long activityScheduleId) {
		// find entity by id
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
		// add activitySchedule
		member.getActivityScheduleIds().add(activitySchedule.getId());
		// save member
		memberRepository.save(member);
		return member.getActivityScheduleIds();
	}

	@Override
	public Set<Long> deleteActivitySchedule(Long memberId, Long activityScheduleId) {
		// find entity by id
		Member member = memberRepository.findById(memberId)
				.orElseThrow(() -> new RuntimeException(String.format("member, id: %d 不存在。", memberId)));
		// delete activitySchedule
		member.getActivityScheduleIds().remove(activityScheduleId);
		memberRepository.save(member);
		return member.getActivityScheduleIds();
	}

}
