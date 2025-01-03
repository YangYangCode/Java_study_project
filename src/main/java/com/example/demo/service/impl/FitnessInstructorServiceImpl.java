package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.FitnessInstructorDTO;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.service.FitnessInstructorService;

@Service
public class FitnessInstructorServiceImpl implements FitnessInstructorService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
	@Autowired
	private ClassTypeRepository classTypeRepository;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;
	
	
	@Override	// 找到所有教練
	public List<FitnessInstructorDTO> getAllFitnessInstructors() {
		return fitnessInstructorRepository.findAll().stream()
				.map(fitnessInstructor -> modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class))
				.collect(Collectors.toList());
	}

	@Override	// 找到指定教練
	public Optional<FitnessInstructorDTO> findFitnessInstructorById(Long id) {
	    Optional<FitnessInstructor> optFitnessInstructor = fitnessInstructorRepository.findById(id);
	    if (optFitnessInstructor.isEmpty()) {
	        return Optional.empty();
	    }
	    // 利用 modelMapper 將 FitnessInstructor 轉 FitnessInstructorDTO
	    return Optional.of(modelMapper.map(optFitnessInstructor.get(), FitnessInstructorDTO.class));
	}

	@Override	// 新增教練
	public FitnessInstructorDTO saveFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO) {
		// DTO -> entity
		FitnessInstructor fitnessInstructor = modelMapper.map(fitnessInstructorDTO, FitnessInstructor.class);
		fitnessInstructorRepository.save(fitnessInstructor);
		// return entity -> DTO
		return modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class);
	}

	@Override	// 修改教練
	public FitnessInstructorDTO updateFitnessInstructor(FitnessInstructorDTO fitnessInstructorDTO, Long id) {
		// 使用 id 找到 entity
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", id)));
		// 將 DTO 數值修改近 entity
		modelMapper.map(fitnessInstructorDTO, fitnessInstructor);
		fitnessInstructorRepository.save(fitnessInstructor);
		return modelMapper.map(fitnessInstructor, FitnessInstructorDTO.class);
	}

	@Override	// 刪除教練
	public void deleteFitnessInstructor(Long id) {
		// 使用 id 找到 entity
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", id)));
		fitnessInstructorRepository.deleteById(id);
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByFitnessInstructor(Long fitnessInstructorId) {
		// find entity by id
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
		// fitnessInstructor -> fitnASList
		List<ActivityScheduleDTO> ASList = fitnessInstructor.getActivitySchedules().stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
		return ASList;
	}
	
//	@Override
//	public Map<Long, String> addClassType(Long fitnessInstructorId, Long classTypeId) {
//		// find entity by id
//		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
//				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
//		ClassType classType = classTypeRepository.findById(classTypeId)
//				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
//		// add classType
//		fitnessInstructor.getClassTypes().put(classType.getId(), classType.getName());
//		// save fitnessInstructor
//		fitnessInstructorRepository.save(fitnessInstructor);
//		return fitnessInstructor.getClassTypes();
//	}
//
//	@Override
//	public Map<Long, String> deleteClassType(Long fitnessInstructorId, Long classTypeId) {
//		// find entity by id
//		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
//				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
//		// delete classType
//		fitnessInstructor.getClassTypes().remove(classTypeId);
//		fitnessInstructorRepository.save(fitnessInstructor);
//		return fitnessInstructor.getClassTypes();
//	}
//
//	@Override
//	public Set<Long> addActivitySchedule(Long fitnessInstructorId, Long activityScheduleId) {
//		// find entity by id
//		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
//				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
//		ActivitySchedule activitySchedule = activityScheduleRepository.findById(activityScheduleId)
//				.orElseThrow(() -> new RuntimeException(String.format("activitySchedule, id: %d 不存在。", activityScheduleId)));
//		// add classType
//		fitnessInstructor.getActivityScheduleIds().add(activitySchedule.getId());
//		// save fitnessInstructor
//		fitnessInstructorRepository.save(fitnessInstructor);
//		return fitnessInstructor.getActivityScheduleIds();
//	}
//
//	@Override
//	public Set<Long> deleteActivitySchedule(Long fitnessInstructorId, Long activityScheduleId) {
//		// find entity by id
//		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
//				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
//		// delete activitySchedule
//		fitnessInstructor.getActivityScheduleIds().remove(activityScheduleId);
//		fitnessInstructorRepository.save(fitnessInstructor);
//		return fitnessInstructor.getActivityScheduleIds();
//	}



}
