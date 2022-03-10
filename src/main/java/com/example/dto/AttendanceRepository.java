package com.example.dto;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	public Optional<Attendance> findByStudentNameAndDate(String name,String startDate);
	//public List<Attendance> findByStudentNameAndDate(String name,Date startDate, Date endDate);
	//findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(OffsetDateTime endDate, OffsetDateTime startDate);
}