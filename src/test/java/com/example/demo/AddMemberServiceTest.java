package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.Member;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class AddMemberServiceTest {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	void add() {
		Member member_1 = new Member();
		member_1.setName("會員a");
		member_1.setUsername("member_a");
		member_1.setPassword("1234");
		memberRepository.save(member_1);
	}
	
}
