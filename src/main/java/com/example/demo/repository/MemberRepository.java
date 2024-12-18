package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Member;

@Repository		// 會員
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUsername(String username);
	
}
