package com.example.demo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

public class MemberServiceImpl implements MemberService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private MemberRepository memberRepository;
	
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

}
