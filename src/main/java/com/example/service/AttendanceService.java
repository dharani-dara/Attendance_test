package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.Attendance;
import com.example.dto.AttendanceRepository;

@Service
public class AttendanceService {
	@Autowired
    private AttendanceRepository attendanceRepository;
    
   
    public Attendance addAttendance(Attendance attendance){
        return attendanceRepository.save(attendance);
    }

    public Attendance getAttendance( Long id){
       return attendanceRepository.findById(id).get();
    }
    
    
    
    public List<Attendance> getAttendance(){
        return attendanceRepository.findAll();
     }
     public void deleteById(Long id) {
    	 attendanceRepository.deleteById(id);
    	 
     }
     public Optional<Attendance> getAttendance(String name,String startDate,String endDate){
         return attendanceRepository.findByStudentNameAndDate(name, startDate);
      }
     public Optional<Attendance> getByID(Long id)
     {
    	 return attendanceRepository.findById(id);
     }
     public Attendance updateAttendance(Attendance attendance  ,Long id) {
    	 Attendance attend=attendanceRepository.findById(id).get();
    	 attend.setDate(attendance.getDate());
    	 attend.setStatus(attendance.isStatus());
    	 attend.setStudentClass(attendance.getStudentClass());
    	 attend.setStudentName(attendance.getStudentName());
    	 attendanceRepository.save(attend);
    	 return attend;
     }
    	 
     }
