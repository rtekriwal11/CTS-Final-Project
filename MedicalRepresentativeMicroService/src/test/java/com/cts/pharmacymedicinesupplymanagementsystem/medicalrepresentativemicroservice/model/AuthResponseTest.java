package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthResponseTest {

	AuthResponse authResponse;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		authResponse=new AuthResponse();
		authResponse.setUid("admin");
		authResponse.setName("admin");
		authResponse.setValid(true);
	}
	
	@Test
	public void testallmethods() {
		assertEquals("admin",authResponse.getUid());
		assertEquals("admin",authResponse.getName());
		assertTrue(authResponse.isValid());
	}
}
