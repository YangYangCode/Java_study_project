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
	void addMembers() {
	    for (int i = 1; i <= 10; i++) {
	        Member member = new Member();
	        member.setName("會員" + i); // 動態生成名稱，例如 會員1, 會員2...
	        member.setUsername("member" + i); // 動態生成用戶名，例如 member1, member2...
	        member.setPassword("1234"); // 統一密碼
	        memberRepository.save(member);
	    }
	}
	
}
