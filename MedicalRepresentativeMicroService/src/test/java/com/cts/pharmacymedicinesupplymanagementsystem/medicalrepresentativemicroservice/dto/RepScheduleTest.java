package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.Doctor;

@ExtendWith(MockitoExtension.class)
class RepScheduleTest {

	RepSchedule repSchedule;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		repSchedule=new RepSchedule("R1", "D1", "Orthopaedics", "medicine", "1pm", "2021-07-01", "9876543210");
	}
	
	@Test
	public void testmethods() {
		assertEquals("R1",repSchedule.getMedicalRepName());
		assertEquals("D1",repSchedule.getDoctorName());
		assertEquals("Orthopaedics",repSchedule.getTreatingAilment());
		assertEquals("medicine",repSchedule.getMedicine());
		assertEquals("1pm",repSchedule.getMeetingSlot());
		assertEquals("2021-07-01",repSchedule.getDate_Of_Meeting());
		assertEquals("9876543210",repSchedule.getDoctorNumber());
	}
	
	@Test
	public void testsetter() {
		repSchedule.setDate_Of_Meeting("2021");
		repSchedule.setDoctorName("D1");
		repSchedule.setDoctorNumber("9876543210");
		repSchedule.setMedicalRepName("R1");
		repSchedule.setMedicine("medicine");
		repSchedule.setMeetingSlot("1pm");
		repSchedule.setTreatingAilment("Orthopaedics");
		assertEquals("R1",repSchedule.getMedicalRepName());
		assertEquals("D1",repSchedule.getDoctorName());
		assertEquals("Orthopaedics",repSchedule.getTreatingAilment());
		assertEquals("medicine",repSchedule.getMedicine());
		assertEquals("1pm",repSchedule.getMeetingSlot());
		assertEquals("2021",repSchedule.getDate_Of_Meeting());
		assertEquals("9876543210",repSchedule.getDoctorNumber());
	}
	

}
