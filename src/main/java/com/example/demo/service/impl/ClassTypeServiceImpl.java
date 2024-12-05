package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ClassTypeDTO;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.service.ClassTypeService;

@Service
public class ClassTypeServiceImpl implements ClassTypeService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClassTypeRepository classTypeRepository;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	
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

	@Override	// 課程新增教室
	public Map<Long, String> addClassRoom(Long classTypeId, Long classRoomId) {
		// find entity by id
		ClassType classType = classTypeRepository.findById(classTypeId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
		ClassRoom classRoom = classRoomRepository.findById(classRoomId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassRoom, id: %d 不存在。", classRoomId)));
		// add classRoom
		classType.getClassRooms().put(classRoom.getId(), classRoom.getName());
		// save classRoom
		classTypeRepository.save(classType);
		return classType.getClassRooms();
	}

	@Override	 // 課程刪除教室
	public Map<Long, String> deleteClassRoom(Long classTypeId, Long classRoomId) {
		// find entity by id
		ClassType classType = classTypeRepository.findById(classTypeId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
		// delete classRoom
		classType.getClassRooms().remove(classRoomId);
		classTypeRepository.save(classType);
		return classType.getClassRooms();
	}

	@Override
	public Map<Long, String> addFitnessInstructor(Long classTypeId, Long fitnessInstructorId) {
		// find entity by id
		ClassType classType = classTypeRepository.findById(classTypeId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
		FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(fitnessInstructorId)
				.orElseThrow(() -> new RuntimeException(String.format("fitnessInstructor, id: %d 不存在。", fitnessInstructorId)));
		// add fitnessInstructor
		classType.getFitnessInstructors().put(fitnessInstructor.getId(), fitnessInstructor.getName());
		// save classType
		classTypeRepository.save(classType);
		return classType.getFitnessInstructors();
	}

	@Override
	public Map<Long, String> deleteFitnessInstructor(Long classTypeId, Long fitnessInstructorId) {
		// find entity by id
		ClassType classType = classTypeRepository.findById(classTypeId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
		// delete fitnessInstructor
		classType.getFitnessInstructors().remove(fitnessInstructorId);
		classTypeRepository.save(classType);
		return classType.getFitnessInstructors();
	}

}
