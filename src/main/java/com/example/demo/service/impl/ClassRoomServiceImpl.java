package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.service.ClassRoomService;

public class ClassRoomServiceImpl implements ClassRoomService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	
	@Override	// 找到所有教室
	public List<ClassRoomDTO> getAllClassRooms() {
		return classRoomRepository.findAll().stream()
				.map(classRoom -> modelMapper.map(classRoom, ClassRoomDTO.class))
				.collect(Collectors.toList());
	}

	@Override	// 找到教室 by id
	public Optional<ClassRoomDTO> findClassRoomById(Long id) {
		Optional<ClassRoom> optClassRoom = classRoomRepository.findById(id);
		if(optClassRoom.isEmpty()) {
			return Optional.empty();
		}
		// modelMapper, entity -> DTO
		return Optional.of(modelMapper.map(optClassRoom.get(), ClassRoomDTO.class));
	}

	@Override
	public ClassRoomDTO saveClassRoom(ClassRoomDTO classRoomDTO) {
		// DTO -> entity
		ClassRoom classRoom = modelMapper.map(classRoomDTO, ClassRoom.class);
		classRoomRepository.save(classRoom);
		// return entity -> DTO
		return modelMapper.map(classRoom, ClassRoomDTO.class);
	}

	@Override
	public ClassRoomDTO updateClassRoom(ClassRoomDTO classRoomDTO, Long id) {
		// 使用 id 找到 entity
		ClassRoom classRoom = classRoomRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("classRoom, id: %d 不存在。", id)));
		// 將 DTO 數值修改近 entity
		modelMapper.map(classRoomDTO, classRoom);
		classRoomRepository.save(classRoom);
		return modelMapper.map(classRoom, ClassRoomDTO.class);
	}

	@Override
	public void deleteClassRoom(Long id) {
		// 使用 id 找到 entity
		ClassRoom classRoom = classRoomRepository.findById(id)
				.orElseThrow(() -> new RuntimeException(String.format("ClassRoom, id: %d 不存在。", id)));
		classRoomRepository.deleteById(id);
	}

}
