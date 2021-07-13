package com.cts.pharmacyMedicineSupply.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.pharmacyMedicineSupply.dto.RepSchedule;
import com.cts.pharmacyMedicineSupply.service.RepresentativeService;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RepController {

	//This reference is connected to service class 
	@Autowired
	RepresentativeService repService;
	
	@GetMapping("/RepSchedule")
	public List<RepSchedule> getSchedule(@RequestParam String date) {
		log.info("In Progress to get the schedule");
		List<RepSchedule> schedule=repService.listschedule(date);
		log.info("Got the schedule");
		return schedule;
	}
}
