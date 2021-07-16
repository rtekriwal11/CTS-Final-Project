package com.cts.pharmacyMedicineSupply.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pharmacyMedicineSupply.Repository.DoctorRepo;
import com.cts.pharmacyMedicineSupply.dto.RepSchedule;
import com.cts.pharmacyMedicineSupply.feign.AuthClient;
import com.cts.pharmacyMedicineSupply.feign.StockFeignClient;
import com.cts.pharmacyMedicineSupply.model.AuthResponse;
import com.cts.pharmacyMedicineSupply.model.Doctor;
import com.cts.pharmacyMedicineSupply.model.MedicalRep;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RepresentativeServiceImpl implements RepresentativeService {

	@Autowired
	AuthClient authClient;
	
	@Autowired
	DoctorRepo doctorRepo;
	
	@Autowired
	MedicalRepService medicalRepService;
	
	@Autowired
	StockFeignClient stockFeignClient;
	
	/*
	 * This methods takes date input in form of String
	 * Returns List of RepSchedule
	 * 
	 */
	
	@Override
	public List<RepSchedule> listschedule(String dt) {
		LocalDate startDate=stringToDate(dt);
		log.info("Inside Service method for schedule");
		String[] date=getListOfDates(startDate);
		
		List<RepSchedule> schedule=new ArrayList<>();
		log.info("PRINTED LIST OF MedRep");
		List<MedicalRep> listOfMedRep=medicalRepService.sendRep();
		int increase_date_count=0;
		int count_of_rep=0;
		List<String> listofmed=new ArrayList<>();
		for(int j=1;j<=doctorRepo.count();j++) {
			listofmed.clear();
			Doctor d=doctorRepo.getOne(j);
			String docName=d.getDoctorname();
			log.info("DOCTOR'S NAME:"+docName);
			String slot="1 PM to 2 PM";
			log.info("DOCTOR'S TIME SLOT:"+slot);
			String contactNumber=d.getContactnumber();
			log.info("DOCTOR'S CONTACT NUMBER:"+contactNumber);
			String targetAilment=d.getTreatingailment();
			log.info("DOCTOR'S TARGETING AILMENT:"+targetAilment);
			listofmed=stockFeignClient.getMedicineByTreatingAilment(targetAilment);
			String med = String.join(",", listofmed);
			System.out.println(med);
			schedule.add(new RepSchedule(listOfMedRep.get(count_of_rep++).getMedicalRepName(),docName,targetAilment,med,slot,date[increase_date_count++],contactNumber));
			if(count_of_rep==3)count_of_rep=0;
		}		
		return schedule;
	}
	
	/*
	 * This method takes startDate as input
	 * Returns String of dates for appointment as output
	 */
	public String[] getListOfDates(LocalDate startDate) {
		String[] date=new String[5];
		for(int i=0;i<5;i++) {
			if(!startDate.getDayOfWeek().toString().equals("SUNDAY")) {
				date[i]=startDate.toString();
			}
			else {
				startDate=startDate.plusDays(1);
				date[i]=startDate.toString();
			}
			startDate=startDate.plusDays(1);
		}
		return date;
	}

	/*
	 * This methods takes String date as Input 
	 * And return Date in the form of LocalDate
	 */
	public LocalDate stringToDate(String dt) {
		LocalDate localDate = LocalDate.parse(dt);
		return localDate;
	}
	
	/*
	 * This method takes token as input
	 * returns if token input is true or false
	 */
	public boolean isSessionValid(String token) {
		try {
			AuthResponse authResponse = authClient.getValidity(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	

}
