package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * This class is responsible for creating all objects, dependency injection and
 * managing the life cycle of all beans
 * 
 */

@SpringBootApplication
@EnableFeignClients
public class PharmacySupplyModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacySupplyModuleApplication.class, args);
	}

}
