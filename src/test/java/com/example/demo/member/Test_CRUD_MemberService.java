package com.example.demo.member;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.dto.ActivityManagerDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.dto.MemberDTO;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.service.ActivityManagerService;
import com.example.demo.service.ClassRoomService;
import com.example.demo.service.ClassTypeService;
import com.example.demo.service.FitnessInstructorService;
import com.example.demo.service.MemberService;

@SpringBootTest
public class Test_CRUD_MemberService {

	@Autowired
	MemberService memberService;

	@Test
	void mix() {
	    MemberDTO member = new MemberDTO();
	    String add_Name;
	    String update_Name;
	    
	    // add
	    member.setName("新會員");
	    member = memberService.saveMember(member);
	    add_Name = member.getName();
	    
	    // getId
	    Long memberId = member.getId();
	    
	    // find
	    MemberDTO find = memberService.findMemberById(memberId);
	    
	    // update
	    member.setName("更新會員");
	    memberService.updateMember(member, memberId);
	    update_Name = member.getName();
	    
	    // delete
	    memberService.deleteMember(memberId);
	    
	    if(find != null) { System.out.println("find ok"); }
	    System.out.println(add_Name);
	    System.out.println(update_Name);
	}
	
}