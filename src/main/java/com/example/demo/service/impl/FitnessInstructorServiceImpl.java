package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.service.FitnessInstructorService;

public class FitnessInstructorServiceImpl implements FitnessInstructorService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
	@Override
	public List<FitnessInstructorDTO> getAllFitnessInstructors() {
		return fitnessInstructorRepository.findAll().stream()
				.map(fitnessInstructor -> modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<FitnessInstructorDTO> findFitnessInstructorById(Long id) {
		Optional<FitnessInstructor> optFitnessInstructor = fitnessInstructorRepository.findById(id);
		if(optFitnessInstructor.isEmpty()) {
			return Optional.empty();
		}
		// modelMapper, entity -> DTO
		return Optional.of(modelMapper.map(optFitnessInstructor.get(), FitnessInstructorDTO.class));
	}

	@Override
	public FitnessInstructorDTO saveFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO) {
		// DTO -> entity
		FitnessInstructor fitnessInstructor = modelMapper.map(fitnessInstructorDTO, FitnessInstructor.class);
		fitnessInstructorRepository.save(fitnessInstructor);
		// return entity -> DTO
		return modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class);
	}

	@Override
	public FitnessInstructorDTO updateFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO, Long id) {
		// 使用 id 找到 entity
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", id)));
		// 將 DTO 數值修改近 entity
		modelMapper.map(fitnessInstructorDTO, fitnessInstructor);
		fitnessInstructorRepository.save(fitnessInstructor);
		return modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class);
	}

	@Override
	public void deleteFitnessInstructor(Long id) {
		// 使用 id 找到 entity
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", id)));
		fitnessInstructorRepository.deleteById(id);
	}

}
