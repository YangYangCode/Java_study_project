package com.example.demo.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Member;
import com.example.demo.repository.MemberRepository;

@SpringBootTest
public class Test_Add_MemberService {

	@Autowired
	MemberRepository memberRepository;
	
	@Test
	void add() {
		Member member_1 = new Member();
		member_1.setName("李會員");
		member_1.setUsername("member");
		member_1.setPassword("1234");
		memberRepository.save(member_1);
	}
	
}
