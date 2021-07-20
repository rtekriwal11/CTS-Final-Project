package com.cts.pharmacyMedicineSupply.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.pharmacyMedicineSupply.dto.AuthResponse;
import com.cts.pharmacyMedicineSupply.dto.UserData;

//@FeignClient(name = "authorization-service", url = "http://localhost:9095/authorization")
@FeignClient(name = "authorization-service", url = "ij021-pod3-lb-1742857365.us-east-2.elb.amazonaws.com/authorization")
public interface AuthClient {

	@PostMapping(value = "/login")
	public UserData login(@RequestBody UserData userlogincredentials);

	@GetMapping(value = "/validate")
	public AuthResponse getValidity(@RequestHeader("Authorization") String token);

}

