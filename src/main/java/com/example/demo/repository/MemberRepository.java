package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Member;

import jakarta.transaction.Transactional;

@Repository		// 會員
public interface MemberRepository extends JpaRepository<Member, Long> {

	Optional<Member> findByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM member_activity_schedules WHERE signed_members_id = :memberId AND activity_schedule_id = :activityScheduleId", nativeQuery = true)
	void deleteSignAS(@Param("memberId") Long memberId, @Param("activityScheduleId") Long activityScheduleId);
	
}
