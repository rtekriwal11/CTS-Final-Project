package com.cts.pharmacyMedicineSupply.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatedtoTest {

	Datedto datedto;
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		datedto=new Datedto("2021-07-21"); 
	}
	
	@Test
	public void testmethods() {
		assertEquals("2021-07-21",datedto.getDate());
	}
	
	@Test
	public void testsetter() {
		datedto.setDate("2021-07-31");
		assertEquals("2021-07-31",datedto.getDate());
	}
	
	@Test
	public void testToString() {
		Datedto d=new Datedto();
		String val=d.toString();
		assertEquals(val,d.toString());
	}
	
	@Test
	public void testEquals_Symmetric() {
		Datedto user=new Datedto("2021-07-21"); 
	    assertTrue(datedto.equals(user) && user.equals(datedto));
	    assertTrue(datedto.hashCode() == user.hashCode());
	}

}
