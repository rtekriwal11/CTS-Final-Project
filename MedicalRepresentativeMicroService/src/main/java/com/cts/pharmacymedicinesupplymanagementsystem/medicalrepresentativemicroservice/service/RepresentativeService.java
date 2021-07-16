package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.dto.RepSchedule;


public interface RepresentativeService {

	List<RepSchedule> listschedule(String startDate);

	boolean isSessionValid(String token);
	
	LocalDate stringToDate(String dt);

	String[] getListOfDates(LocalDate startDate);
}
