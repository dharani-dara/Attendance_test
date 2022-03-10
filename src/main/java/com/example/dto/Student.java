package com.example.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {
	@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long studId;
    @Column
    private String studentClass;
    @Column
    private String studentName;
    @OneToMany(cascade = CascadeType.ALL)
  	private List<Attendance> attendanceList;
	public Long getStudId() {
		return studId;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public String getStudentName() {
		return studentName;
	}
	public List<Attendance> getAttendanceList() {
		return attendanceList;
	}
	public void setStudId(Long studId) {
		this.studId = studId;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public void setAttendanceList(List<Attendance> attendanceList) {
		this.attendanceList = attendanceList;
	}
	public Student(Long studId, String studentClass, String studentName, List<Attendance> attendanceList) {
		super();
		this.studId = studId;
		this.studentClass = studentClass;
		this.studentName = studentName;
		this.attendanceList = attendanceList;
	}
   
	
}
