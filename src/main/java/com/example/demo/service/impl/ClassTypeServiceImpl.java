package com.example.demo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.entity.ClassType;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.service.ClassTypeService;

public class ClassTypeServiceImpl implements ClassTypeService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClassTypeRepository classTypeRepository;
	
	@Override
	public List<ClassTypeDTO> getAllClassTypes() {
		return classTypeRepository.findAll().stream()
				.map(classType -> modelMapper.map(classType, ClassTypeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ClassTypeDTO saveClassType(ClassTypeDTO classTypeDTO) {
		// DTO -> entity
		ClassType classType = modelMapper.map(classTypeDTO, ClassType.class);
		classTypeRepository.save(classType);
		// return entity -> DTO
		return modelMapper.map(classType, ClassTypeDTO.class);
	}

	@Override
	public ClassTypeDTO updateClassType(ClassTypeDTO classTypeDTO, Long id) {
		// 使用 id 找到 entity
		ClassType classType = classTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("classType, id: %d 不存在。", id)));
		// 將 DTO 數值修改進 entity
		modelMapper.map(classTypeDTO, classType);
		classTypeRepository.save(classType);
		return modelMapper.map(classType, ClassTypeDTO.class);
	}

	@Override
	public void deleteClassType(Long id) {
		// 使用 id 找到 entity
		ClassType classType = classTypeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("classType, id: %d 不存在。", id)));
		classTypeRepository.deleteById(id);
	}

}
