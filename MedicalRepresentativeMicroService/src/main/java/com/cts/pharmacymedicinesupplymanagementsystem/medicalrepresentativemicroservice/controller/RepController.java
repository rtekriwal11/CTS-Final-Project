package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service.RepresentativeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/medicalrep")
public class RepController {
	
	//This reference is connected to service class 
	@Autowired
	RepresentativeService repService;
	
	
	
	@GetMapping("/RepSchedule")
	public ResponseEntity<?> getSchedule(@RequestHeader("Authorization") String token,@RequestParam String date) {
		log.info("In Progress to get the schedule");
		if (repService.isSessionValid(token)) {
			log.info("TOKEN IS ACCEPTED NOW TAKING LIST");
			return new ResponseEntity<>(repService.listschedule(date), HttpStatus.OK);
		}
		log.info("///////////////////////////////////not accepted token///");
		log.info("Got the schedule");
		return null;
	}
}
