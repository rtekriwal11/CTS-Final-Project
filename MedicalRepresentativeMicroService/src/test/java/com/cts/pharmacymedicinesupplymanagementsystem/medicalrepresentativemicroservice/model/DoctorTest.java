package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DoctorTest {
	
	
	Doctor doctor;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		doctor=new Doctor();
		doctor.setId(0);
		doctor.setDoctorname("D1");doctor.setTreatingailment("Orthopaedics");
		doctor.setContactnumber("9884122113");
	}
	
	
	@Test
	public void testDoctorDetails() {
		assertEquals(0,doctor.getId());
		assertEquals("D1",doctor.getDoctorname());
		assertEquals("9884122113",doctor.getContactnumber());
		assertEquals("Orthopaedics",doctor.getTreatingailment());
		
	}
	@Test
	public void testsetmethod() {
		doctor.setId(0);
		doctor.setDoctorname("D1");doctor.setTreatingailment("Orthopaedics");
		doctor.setContactnumber("9884122113");
		assertEquals(0,doctor.getId());
		assertEquals("D1",doctor.getDoctorname());
		assertEquals("9884122113",doctor.getContactnumber());
		assertEquals("Orthopaedics",doctor.getTreatingailment());
	}
	
	@Test
	public void testToString() {
		String val=doctor.toString();
		assertEquals(val,doctor.toString());
	}
	
	@Test
	public void testEquals_Symmetric() {
		Doctor y=new Doctor(0,"D1","9884122113","Orthopaedics");
	    assertTrue(doctor.equals(y) && y.equals(doctor));
	    assertTrue(doctor.hashCode() == y.hashCode());
	}

}
