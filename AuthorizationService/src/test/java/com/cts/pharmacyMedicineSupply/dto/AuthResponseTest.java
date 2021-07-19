package com.cts.pharmacyMedicineSupply.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AuthResponseTest {

AuthResponse authResponse;
	
	@Before
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		authResponse=new AuthResponse("admin","admin",true);
		//authResponse.setUid("admin");
		//authResponse.setName("admin");
		//authResponse.setValid(true);
	}
	
	@Test
	public void testallmethods() {
		assertEquals("admin",authResponse.getUid());
		assertEquals("admin",authResponse.getName());
		assertTrue(authResponse.isValid());
	}
	
	@Test
	public void testsetmethod() {
		authResponse.setUid("admin");
		authResponse.setName("admin");
		authResponse.setValid(true);
		assertEquals("admin",authResponse.getUid());
		assertEquals("admin",authResponse.getName());
		assertTrue(authResponse.isValid());
	}
	
	@Test
	public void testToString() {
		String val=authResponse.toString();
		assertEquals(val,authResponse.toString());
	}
	
	@Test
	public void testEquals_Symmetric() {
	    AuthResponse y = new AuthResponse("admin","admin",true);
	    assertTrue(authResponse.equals(y) && y.equals(authResponse));
	    assertTrue(authResponse.hashCode() == y.hashCode());
	}
}
