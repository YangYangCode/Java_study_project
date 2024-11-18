package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.entity.Class;

@Repository
public interface ClassRepository extends JpaRepository<Class, Long> {

}
