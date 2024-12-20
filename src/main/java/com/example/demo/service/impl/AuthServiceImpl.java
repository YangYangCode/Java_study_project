package com.example.demo.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ActivityManager;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityManagerRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;

	@Autowired
	private ActivityManagerRepository activityManagerRepository;

	@Override
	public Optional<MemberDTO> memberLogin(String username, String password) {
		// 使用 UserName 尋找
		Optional<Member> optMember = memberRepository.findByUsername(username);

		// 判斷密碼
		if (optMember.isPresent() && optMember.get().getPassword().equals(password)) {
			return Optional.of(modelMapper.map(optMember.get(), MemberDTO.class));
		}
		return Optional.empty();
	}

	@Override
	public Optional<FitnessInstructorDTO> fitnLogin(String username, String password) {
		// 使用 UserName 尋找
		Optional<FitnessInstructor> optFitnessInstructor = fitnessInstructorRepository.findByUsername(username);

		// 判斷密碼
		if (optFitnessInstructor.isPresent() && optFitnessInstructor.get().getPassword().equals(password)) {
			return Optional.of(modelMapper.map(optFitnessInstructor.get(), FitnessInstructorDTO.class));
		}
		return Optional.empty();
	}

	@Override
	public Optional<ActivityManagerDTO> managerLogin(String username, String password) {
		// 使用 UserName 尋找
		Optional<ActivityManager> optActivityManager = activityManagerRepository.findByUsername(username);

		// 判斷密碼
		if (optActivityManager.isPresent() && optActivityManager.get().getPassword().equals(password)) {
			return Optional.of(modelMapper.map(optActivityManager.get(), ActivityManagerDTO.class));
		}
		return Optional.empty();
	}

}
