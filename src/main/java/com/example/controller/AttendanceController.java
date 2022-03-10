package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.Attendance;
import com.example.service.AttendanceService;

@RestController
@RequestMapping("api")
public class AttendanceController {
	@Value("${spring.mail.username}")
	private String mailID;
	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private JavaMailSender mail;

	@PostMapping("/add")
	public Attendance addAttendance(@RequestBody Attendance attendance) {
		// Attendance a = new
		// Attendance(attendance.getStudentClass(),attendance.getStudentName(),attendance.getDate(),attendance.isStatus());
		return attendanceService.addAttendance(attendance);
	}

	@GetMapping("getAttendance/{id}")
	public Attendance getAttendance(@PathVariable("id") long id) {
		
		return attendanceService.getAttendance(id);
	}

	@GetMapping("getAttendance")
	public List<Attendance> getAttendance() {
		return attendanceService.getAttendance();
	}

	@DeleteMapping("deleteAttendance/{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		attendanceService.deleteById(id);
		return "Deleted";

	}

	@PutMapping("{id}")
	public Attendance updateAttendance(@RequestBody Attendance attendance, @PathVariable("id") long id) {
		return attendanceService.updateAttendance(attendance, id);
	}

	/*
	 * @GetMapping("sendMail") public String sendMail(@RequestParam String mail) {
	 * SimpleMailMessage msg = new SimpleMailMessage(); msg.setTo(mail);
	 * 
	 * msg.setSubject("Testing from Spring Boot");
	 * msg.setText("Hello World \n Spring Boot Email");
	 * 
	 * //((JavaMailSender) msg).send(mail); return "mail sent successfully"; }
	 */
	@GetMapping("report")
	public String report(@RequestParam String name,@RequestParam String startDate,@RequestParam String endDate) {
		System.out.println(mailID);
		Attendance attendancelist1 = attendanceService.getAttendance(name, startDate, endDate).get();
		List<Attendance> attendancelist = new ArrayList<>();
		attendancelist.add(attendancelist1);
		System.out.println(attendancelist);
		Long present = attendancelist.stream().filter(s -> s.isStatus() == true).count();
		Long absent = attendancelist.stream().filter(s -> s.isStatus() == false).count();
		Long Total = present + absent;

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(mailID);

		// message.setText("FATAL - Application crash. Save your job !!");
		message.setSubject("Attendance Report from " + startDate + " to " + endDate);
		message.setText(
				"No. of days present" + present + "\n No. of days absent" + absent + "\n Total no. of days " + Total);

		mail.send(message);
		return "report generated successfully";
	}

	@GetMapping("getByID/{id}")
	public Attendance getByID(@PathVariable Long id) {
		return attendanceService.getByID(id).get();
	}
	// @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
	// private List<Category> categoryList;

	// @ManyToOne
	// @JoinColumn
	// @JsonBackReference
	// private Product product;
	/*
	 * msg.setText( "Dear " + student.getFirstName() + ", \n Your Monthly attendance
	 * status is as follows\n Number of days present"
	 * 
	 * + student.numberofdayspresent()+ ", \n Number of Days Absent \n " +
	 * student.numberofdayabsent()+ + ", thanks \n " + student.teachername());
	 */}