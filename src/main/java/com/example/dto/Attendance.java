package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "attendance")
//@NamedQuery(name = "findByStudentNameAndDate", query = "select a from Attendance a where a.studentName = ?1 and a.date >= ?2 and a.date <= ?3")
public class Attendance {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String studentClass;
	@Column
	private String studentName;

	private String date;
	@Column
	private boolean Status = false;

	public Attendance() {
	}

	public Long getId() {
		return id;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public String getStudentName() {
		return studentName;
	}

	public boolean isStatus() {
		return Status;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStatus(boolean status) {
		Status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Attendance [id=" + id + ", studentClass=" + studentClass + ", studentName=" + studentName + ", date="
				+ date + ", Status=" + Status + "]";
	}

	public Attendance(Long id, String studentClass, String studentName, String date, boolean status, Student student) {
		super();
		this.id = id;
		this.studentClass = studentClass;
		this.studentName = studentName;
		this.date = date;
		Status = status;
	}

}
