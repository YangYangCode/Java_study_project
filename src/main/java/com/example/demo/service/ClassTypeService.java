package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.ClassTypeDTO;

// 課程類型
public interface ClassTypeService {
	// 查詢所有課程類型
	List<ClassTypeDTO> findAllClassTypes();
	
	// 新增課程
	void addClassType(ClassTypeDTO classTypeDTO);
	
	// 修改課程
	void updateClassType(ClassTypeDTO classTypeDTO, Long id);
	
	// 刪除課程
	void deleteClassType(Long id);
	
}

