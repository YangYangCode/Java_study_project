package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.ActivityScheduleService;
import com.example.demo.service.MemberService;

@SpringBootTest
public class memberSignAS {
	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;

	@Autowired
	private MemberService memberService;

	@Test
	public void testSignActivitySchedule() {

		memberService.signActivitySchedule(1L, 1L);
		memberService.signActivitySchedule(1L, 2L);
		memberService.signActivitySchedule(1L, 3L);
		memberService.signActivitySchedule(1L, 4L);
		memberService.signActivitySchedule(1L, 5L);
		memberService.signActivitySchedule(1L, 6L);
		memberService.signActivitySchedule(1L, 7L);
		memberService.signActivitySchedule(1L, 8L);
		memberService.signActivitySchedule(1L, 9L);
		memberService.signActivitySchedule(1L, 10L);
		
		memberService.signActivitySchedule(2L, 1L);
		memberService.signActivitySchedule(2L, 2L);
		memberService.signActivitySchedule(2L, 3L);
		memberService.signActivitySchedule(2L, 4L);
		memberService.signActivitySchedule(2L, 5L);
		memberService.signActivitySchedule(2L, 6L);
		memberService.signActivitySchedule(2L, 7L);
		memberService.signActivitySchedule(2L, 8L);
		memberService.signActivitySchedule(2L, 9L);
		memberService.signActivitySchedule(2L, 10L);
	}
}