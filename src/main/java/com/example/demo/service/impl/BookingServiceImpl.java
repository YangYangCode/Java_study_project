package com.example.demo.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.booking.ListOfBooking;
import com.example.demo.model.dto.booking.OneOfBooking;
import com.example.demo.model.entity.ClassRoom;
import com.example.demo.model.entity.ClassRoomBookingForm;
import com.example.demo.model.entity.FitnessInstructor;
import com.example.demo.model.entity.FitnessInstructorBookingForm;
import com.example.demo.model.entity.FitnessInstructorBookingForm;
import com.example.demo.model.entity.Member;
import com.example.demo.model.entity.MemberBookingForm;
import com.example.demo.repository.ClassRoomRepository;
import com.example.demo.repository.FitnessInstructorRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.booking.ClassRoomBookingFormRepository;
import com.example.demo.repository.booking.FitnesslnstructorBookingFormRepository;
import com.example.demo.repository.booking.MemberBookingFormRepository;
import com.example.demo.service.BookingService;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private MemberRepository memberRepository;
	@Autowired
	private MemberBookingFormRepository memberBookingFormRepository;

	@Autowired
	private ClassRoomRepository classRoomRepository;
	@Autowired
	private ClassRoomBookingFormRepository classRoomBookingFormRepository;

	@Autowired
	private FitnessInstructorRepository fitnessInstructorRepository;
	@Autowired
	private FitnesslnstructorBookingFormRepository fitnesslnstructorBookingFormRepository;


	@Override
	public ListOfBooking getListOfBooking(ListOfBooking listOfBooking) {
		
		switch (listOfBooking.getType()) {
		case "fitnessInstructor": 
			Map<Long, Map<LocalDate, Map<String, Long>>> allFitnBooking = new HashMap<>();
		
			fitnesslnstructorBookingFormRepository.getBookingsByDateRange(listOfBooking.getStartDate(), listOfBooking.getEndDate())
			.stream().forEach(bookDate -> {
				// 取得類型Id
				Long typeId = bookDate.getFitnessInstructor().getId();
				allFitnBooking.putIfAbsent(typeId, new HashMap<LocalDate, Map<String, Long>>());
				// 日期
				LocalDate date = bookDate.getDate();
				Map<LocalDate, Map<String, Long>> dateMap = allFitnBooking.get(typeId);
	            dateMap.putIfAbsent(date, new HashMap<String, Long>());
				// 時段
				String time = bookDate.getTimePeriod();
				Map<String, Long> timeMap = dateMap.get(date);
	            timeMap.putIfAbsent(time, bookDate.getId());
			});
			listOfBooking.setAllBooking(allFitnBooking);
			return listOfBooking;
		
		case "classRoom":
			Map<Long, Map<LocalDate, Map<String, Long>>> allRoomBooking = new HashMap<>();
			
			classRoomBookingFormRepository.getBookingsByDateRange(listOfBooking.getStartDate(), listOfBooking.getEndDate())
			.stream().forEach(bookDate -> {
				// 取得類型Id
				Long classRoomId = bookDate.getClassRoom().getId();
	            allRoomBooking.putIfAbsent(classRoomId, new HashMap<LocalDate, Map<String, Long>>());
	            // 日期
	            LocalDate date = bookDate.getDate();
	            Map<LocalDate, Map<String, Long>> dateMap = allRoomBooking.get(classRoomId);
	            dateMap.putIfAbsent(date, new HashMap<String, Long>());
				// 時段
				String time = bookDate.getTimePeriod();
				Map<String, Long> timeMap = dateMap.get(date);
	            timeMap.putIfAbsent(time, bookDate.getId());
			});
			listOfBooking.setAllBooking(allRoomBooking);
			return listOfBooking;

		case "member":
			Map<Long, Map<LocalDate, Map<String, Long>>> allMemberBooking = new HashMap<>();
			
			memberBookingFormRepository.getBookingsByDateRange(listOfBooking.getStartDate(), listOfBooking.getEndDate())
			.stream().forEach(bookDate -> {
				// 取得類型Id
				Long memberId = bookDate.getMember().getId();
				allMemberBooking.putIfAbsent(memberId, new HashMap<LocalDate, Map<String, Long>>());
	            // 日期
	            LocalDate date = bookDate.getDate();
	            Map<LocalDate, Map<String, Long>> dateMap = allMemberBooking.get(memberId);
	            dateMap.putIfAbsent(date, new HashMap<String, Long>());
				// 時段
				String time = bookDate.getTimePeriod();
				Map<String, Long> timeMap = dateMap.get(date);
	            timeMap.putIfAbsent(time, bookDate.getId());
			});
			listOfBooking.setAllBooking(allMemberBooking);
			return listOfBooking;

		default:
			return (listOfBooking);
			
		}
	}

	@Transactional
	@Override
	public OneOfBooking addBooking(OneOfBooking oneOfBooking) {

		switch (oneOfBooking.getType()) {
		case "fitnessInstructor":
			FitnessInstructorBookingForm fitnBookingForm = new FitnessInstructorBookingForm();

			FitnessInstructor fitnessInstructor = fitnessInstructorRepository.findById(oneOfBooking.getTypeId())
					.orElseThrow(() -> new RuntimeException(
							String.format("fitnessInstructor, id: %d 不存在。", oneOfBooking.getTypeId())));

			fitnBookingForm.setFitnessInstructor(fitnessInstructor);
			fitnBookingForm.setDate(oneOfBooking.getDate());
			fitnBookingForm.setTimePeriod(oneOfBooking.getTimePeriod());
			fitnBookingForm = fitnesslnstructorBookingFormRepository.save(fitnBookingForm);
			
			oneOfBooking.setBookingId(fitnBookingForm.getId());
			return oneOfBooking;

		case "classRoom":
			ClassRoomBookingForm roomBookingForm = new ClassRoomBookingForm();

			ClassRoom classRoom = classRoomRepository.findById(oneOfBooking.getTypeId())
					.orElseThrow(() -> new RuntimeException(String.format("classRoom, id: %d 不存在。", oneOfBooking.getTypeId())));

			roomBookingForm.setClassRoom(classRoom);
			roomBookingForm.setDate(oneOfBooking.getDate());
			roomBookingForm.setTimePeriod(oneOfBooking.getTimePeriod());
			roomBookingForm = classRoomBookingFormRepository.save(roomBookingForm);
			
			oneOfBooking.setBookingId(roomBookingForm.getId());
			return oneOfBooking;

		case "member":
			MemberBookingForm memberBookingForm = new MemberBookingForm();

			Member member = memberRepository.findById(oneOfBooking.getTypeId()).orElseThrow(
					() -> new RuntimeException(String.format("member, id: %d 不存在。", oneOfBooking.getTypeId())));

			memberBookingForm.setMember(member);
			memberBookingForm.setDate(oneOfBooking.getDate());
			memberBookingForm.setTimePeriod(oneOfBooking.getTimePeriod());
			memberBookingForm = memberBookingFormRepository.save(memberBookingForm);
			
			oneOfBooking.setBookingId(memberBookingForm.getId());
			return oneOfBooking;

			default:
				return null;
		}
	}

	@Override
	public void cancelBooking(OneOfBooking oneOfBooking) {

		switch (oneOfBooking.getType()) {
		case "fitnessInstructor":
			FitnessInstructorBookingForm fitnesslnstructorBookingForm = fitnesslnstructorBookingFormRepository
					.findById(oneOfBooking.getBookingId()).orElseThrow(() -> new RuntimeException(
							String.format("booking, id: %d 不存在。", oneOfBooking.getBookingId())));
			fitnesslnstructorBookingFormRepository.deleteById(oneOfBooking.getBookingId());
			break;

		case "classRoom":
			ClassRoomBookingForm classRoomBookingForm = classRoomBookingFormRepository
					.findById(oneOfBooking.getBookingId()).orElseThrow(() -> new RuntimeException(
							String.format("booking, id: %d 不存在。", oneOfBooking.getBookingId())));
			classRoomBookingFormRepository.deleteById(oneOfBooking.getBookingId());
			break;

		case "member":
			MemberBookingForm memberBookingForm = memberBookingFormRepository.findById(oneOfBooking.getBookingId())
					.orElseThrow(() -> new RuntimeException(
							String.format("booking, id: %d 不存在。", oneOfBooking.getBookingId())));
			memberBookingFormRepository.deleteById(oneOfBooking.getBookingId());
			break;
		}
	}

//	private String intToString(int number) {
//		// 來自資料庫，123 -> "0A:00-0B:00"
//		switch (number) {
//		case 8:
//			return "08:00-:09:00";
//		case 9:
//			return "09:00-:10:00";
//		case 10:
//			return "10:00-:11:00";
//		case 11:
//			return "11:00-:12:00";
//		case 12:
//			return "12:00-:13:00";
//		case 13:
//			return "13:00-:14:00";
//		case 14:
//			return "14:00-:15:00";
//		case 15:
//			return "15:00-:16:00";
//		case 16:
//			return "16:00-:17:00";
//		case 17:
//			return "17:00-:18:00";
//		case 18:
//			return "18:00-:19:00";
//		case 19:
//			return "19:00-:20:00";
//		default:
//			return ("輸入數字異常");
//		}
//
//	}
//	
//	private int stringToInt(String timePeriod) {
//		// 輸入資料庫，"0A:00-0B:00" -> 123
//		switch (timePeriod) {
//		case "08:00-09:00":
//			return 8;
//		case "09:00-10:00":
//			return 9;
//		case "10:00-11:00":
//			return 10;
//		case "11:00-12:00":
//			return 11;
//		case "12:00-13:00":
//			return 12;
//		case "13:00-14:00":
//			return 13;
//		case "14:00-15:00":
//			return 14;
//		case "15:00-16:00":
//			return 15;
//		case "16:00-17:00":
//			return 16;
//		case "17:00-18:00":
//			return 17;
//		case "18:00-19:00":
//			return 18;
//		case "19:00-20:00":
//			return 19;
//		default:
//			return (-1);
//		}
//	}

}
