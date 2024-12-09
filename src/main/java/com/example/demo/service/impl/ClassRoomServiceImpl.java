package com.example.demo.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.ActivityScheduleDTO;
import com.example.demo.model.dto.ClassRoomDTO;
import com.example.demo.model.entity.ActivitySchedule;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassType;
import com.example.demo.repository.ActivityScheduleRepository;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.ClassTypeRepository;
import com.example.demo.service.ClassRoomService;

@Service
public class ClassRoomServiceImpl implements ClassRoomService{

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;
	
	@Autowired
	private ClassTypeRepository classTypeRepository;
	
	@Autowired
	private ActivityScheduleRepository activityScheduleRepository;
	
	
	@Override	// 找到所有教室
	public List<ClassRoomDTO> getAllClassRooms() {
		return classRoomRepository.findAll().stream()
				.map(classRoom -> modelMapper.map(classRoom, ClassRoomDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ClassRoomDTO> findClassRoomById(Long id) {
	    Optional<ClassRoom> optClassRoom = classRoomRepository.findById(id);
	    if (optClassRoom.isEmpty()) {
	        return Optional.empty();
	    }
	    // 利用 modelMapper 將 ClassRoom 轉 ClassRoomDTO
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

	@Override	// 教室新增課程
	public Map<Long, String> addClassType(Long classRoomId, Long classTypeId) {
		// find entity by id
		ClassRoom classRoom = classRoomRepository.findById(classRoomId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassRoom, id: %d 不存在。", classRoomId)));
		ClassType classType = classTypeRepository.findById(classTypeId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassType, id: %d 不存在。", classTypeId)));
		// add classType
		classRoom.getClassTypes().put(classType.getId(), classType.getName());
		// save classRoom
		classRoomRepository.save(classRoom);
		return classRoom.getClassTypes();
	}

	@Override	// 教室刪除課程
	public Map<Long, String> deleteClassType(Long classRoomId, Long classTypeId) {
		// find entity by id
		ClassRoom classRoom = classRoomRepository.findById(classRoomId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassRoom, id: %d 不存在。", classRoomId)));
		// delete classType
		classRoom.getClassTypes().remove(classTypeId);
		classRoomRepository.save(classRoom);
		return classRoom.getClassTypes();
	}

	@Override
	public List<ActivityScheduleDTO> findActivityScheduleByClassRoom(Long classRoomId) {
		// find entity by id
		ClassRoom classRoom = classRoomRepository.findById(classRoomId)
				.orElseThrow(() -> new RuntimeException(String.format("ClassRoom, id: %d 不存在。", classRoomId)));
		// classRoom -> classRoomASList
		List<ActivityScheduleDTO> ASList = classRoom.getActivitySchedules().stream()
				.map(activitySchedule -> modelMapper.map(activitySchedule, ActivityScheduleDTO.class))
				.collect(Collectors.toList());
		return ASList;
	}

	
	
	

}
