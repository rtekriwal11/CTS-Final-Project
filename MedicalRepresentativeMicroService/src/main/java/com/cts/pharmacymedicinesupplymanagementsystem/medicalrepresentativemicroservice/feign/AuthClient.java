package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.AuthResponse;

@FeignClient(name = "authorization-service", url = "http://localhost:9095/authorization")
public interface AuthClient {
	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);
}
