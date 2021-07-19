package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="http://localhost:8080/stock", name="stockMedicine")
public interface StockFeignClient {
	
	
	@GetMapping(value="/byTreatingAilment/{treatingAilment}")
	public List<String> getMedicineByTreatingAilment(@PathVariable("treatingAilment") String treatingAilment);
}
