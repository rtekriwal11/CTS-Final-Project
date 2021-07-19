package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.feingclient.*;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.service.PharmacyMedicineSupplyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/pharmacysupply")
public class PharmacySupplyModuleController {
	
	@Autowired
	private PharmacyMedicineSupplyService service;
	
	@Autowired
	private StockFeignClient stockFeignClient;
	
	@GetMapping(value="/viewDemand")
	public String showSupplyHomePage(@RequestHeader("Authorization") String token){
		log.info("Starting showSupplyHomePage");
		boolean isvalid=service.isSessionValid(token).booleanValue();
		if (isvalid) {
			return "viewDemand";
		}
		log.info("Ending showSupplyHomePage");
		return "login";
	}

	@GetMapping(value="/SupplyAvailed")
	public ResponseEntity<?> showList(@RequestHeader("Authorization") String token,@RequestParam String name, @RequestParam int demand){
		log.info("Starting showList");
		boolean isvalid=service.isSessionValid(token);
		if (isvalid) {
			int stock = stockFeignClient.getStockCountForMedicine(name);
			log.info("Ending showList");
			return new ResponseEntity<>(service.retrievePharmacies(token,demand,name,stock), HttpStatus.OK);
		}
		log.info("Ending showList");
		return null;
	}
	
	
	
}
	
	