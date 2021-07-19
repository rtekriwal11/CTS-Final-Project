package com.cts.pharmacyMedicineSupply.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserDataTest {

UserData userData;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		userData=new UserData("userid","upassword","uname","auth"); 
	}
	
	@Test
	public void testmethods() {
		assertEquals("userid",userData.getUserid());
		assertEquals("uname",userData.getUname());
		assertEquals("upassword",userData.getUpassword());
		assertEquals("auth",userData.getAuthToken());
		
	}
	
	@Test
	public void testsetter() {
		userData.setAuthToken("auth");
		userData.setUname("uname");
		userData.setUpassword("upassword");
		userData.setAuthToken("auth");
		assertEquals("userid",userData.getUserid());
		assertEquals("uname",userData.getUname());
		assertEquals("upassword",userData.getUpassword());
		assertEquals("auth",userData.getAuthToken());
	}
	
	@Test
	public void testToString() {
		UserData user=new UserData();
		String val=user.toString();
		assertEquals(val,user.toString());
	}
	
	@Test
	public void testEquals_Symmetric() {
		UserData user=new UserData("userid","upassword","uname","auth"); 
	    assertTrue(user.equals(userData) && userData.equals(user));
	    assertTrue(userData.hashCode() == user.hashCode());
	}

}
