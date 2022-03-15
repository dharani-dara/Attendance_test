package com.example.controller;



import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.DemoApplication;
import com.example.dto.Attendance;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith({ SpringExtension.class, MockitoExtension.class })
@ContextConfiguration(classes = { DemoApplication.class })
class AttendanceControllerTest {

	@Autowired
	private MockMvc mockMvc;

//		@Mock
//		Attendance attendance;

	public static String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	void testAddAttendance() throws Exception {
		Attendance attendance = new Attendance();
		attendance.setDate("27-11-2022");
		attendance.setId(102L);
		attendance.setStatus(true);
		attendance.setStudentClass("10th");
		attendance.setStudentName("tyisnk");

		String inputJson = AttendanceControllerTest.mapToJson(attendance);
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/api/add")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void testGetAttendanceLong() throws Exception {

		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/getAttendance/23").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());

	}

	@Test
	void testGetAttendance() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/getAttendance").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}
/*
	@Test
	void testDeleteStudent() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.delete("/api/deleteAttendance/7").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}
*/
	@Test
	void testDeleteStudent() throws Exception {
	
	}
	@Test
	void testUpdateAttendance() throws Exception {
		Attendance attendance = new Attendance();
		attendance.setStatus(true);
		attendance.setStudentClass("10th");
		attendance.setStudentName("abcd");
		String inputJson = AttendanceControllerTest.mapToJson(attendance);
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.put("/api/23").contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void testReport() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/report?endDate=22-11-2022&name=ahdbje&startDate=22-11-2022").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());
	}

	@Test
	void testGetByID() throws Exception {
		MvcResult result = mockMvc.perform(
				MockMvcRequestBuilders.get("/api/getByID/23").contentType(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		assertEquals(200, result.getResponse().getStatus());

	}

}
