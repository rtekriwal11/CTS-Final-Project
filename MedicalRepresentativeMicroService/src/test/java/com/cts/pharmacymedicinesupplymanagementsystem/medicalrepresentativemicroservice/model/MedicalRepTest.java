package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicalRepTest {

MedicalRep medicalRep;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		medicalRep=new MedicalRep();
	}
	
	@Test
	public void testallmethods() {
		MedicalRep r=new MedicalRep("R1","987");
		assertEquals("R1",r.getMedicalRepName());
		assertEquals("987",r.getContactNumber());
	}
	@Test
	public void testsetmethod() {
		medicalRep.setContactNumber("987");
		medicalRep.setMedicalRepName("R1");
		assertEquals("R1",medicalRep.getMedicalRepName());
		assertEquals("987",medicalRep.getContactNumber());
	}
	
	@Test
	public void testToString() {
		String val=medicalRep.toString();
		assertEquals(val,medicalRep.toString());
	}
	
	@Test
	public void testEquals_Symmetric() {
		MedicalRep y = new MedicalRep("R1","987");
		MedicalRep x=new MedicalRep("R1","987");
	    assertTrue(x.equals(y) && y.equals(x));
	    assertTrue(x.hashCode() == y.hashCode());
	}

}
