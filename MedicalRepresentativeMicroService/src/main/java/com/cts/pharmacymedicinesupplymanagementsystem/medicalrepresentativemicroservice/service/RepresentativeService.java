package com.cts.pharmacyMedicineSupply.service;

import java.time.LocalDate;
import java.util.List;


import com.cts.pharmacyMedicineSupply.dto.RepSchedule;


public interface RepresentativeService {

	List<RepSchedule> listschedule(String startDate);

	boolean isSessionValid(String token);
	
	LocalDate stringToDate(String dt);

	String[] getListOfDates(LocalDate startDate);
}
