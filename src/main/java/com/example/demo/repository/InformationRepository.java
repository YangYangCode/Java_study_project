package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Information;

@Repository		// 活動的詳細內容
public interface InformationRepository extends JpaRepository<Information, Long> {

}
