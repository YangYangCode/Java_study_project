package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.ClassRoom;

@Repository
public interface RoomRepository extends JpaRepository<ClassRoom, Long> {

}
