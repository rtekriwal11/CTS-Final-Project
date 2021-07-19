package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model;

import lombok.Data;

/**
 * Model class whose fields are used for the response for token validation.
 */
//@Data
public class AuthResponse {
	public AuthResponse(String string, String string2, boolean b) {
		uid=string;
		name=string2;
		isValid=b;
	}
	private String uid;
	private String name;
	private boolean isValid;
}
