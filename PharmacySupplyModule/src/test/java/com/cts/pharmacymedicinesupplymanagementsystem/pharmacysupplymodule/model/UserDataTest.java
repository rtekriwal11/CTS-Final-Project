package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class UserDataTest {
	UserData userData;
	UserData userDataDefault;
	AuthResponse authResponse;
	
	@Before
	public void setUp() {
		userData = new UserData("admin","pwd","name","123");
		userDataDefault = new UserData();
		userDataDefault.setUserid("admin");
		userDataDefault.setUpassword("pwd");
		userDataDefault.setAuthToken("123");
		userDataDefault.setUname("name");
		authResponse = new AuthResponse("uid", "name", true);
		
	}
	

	@Test
	public void test() {
		assertEquals("admin", userData.getUserid());
		assertEquals("pwd", userData.getUpassword());
		assertEquals("name", userData.getUname());
		assertEquals("123", userData.getAuthToken());
		assertEquals("admin", userDataDefault.getUserid());
		assertEquals("pwd", userDataDefault.getUpassword());
		assertEquals("name", userDataDefault.getUname());
		assertEquals("123", userDataDefault.getAuthToken());
	}

}
