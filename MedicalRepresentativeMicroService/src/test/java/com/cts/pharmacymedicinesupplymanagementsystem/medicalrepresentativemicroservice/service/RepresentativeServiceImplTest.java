package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.feign.AuthClient;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.feign.StockFeignClient;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.AuthResponse;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.Doctor;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.MedicalRep;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.repository.DoctorRepo;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service.MedicalRepService;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service.RepresentativeServiceImpl;
@ExtendWith(MockitoExtension.class)
class RepresentativeServiceImplTest {

	
	 @InjectMocks 
	 RepresentativeServiceImpl representativeServiceImpl;
	 
	 //@BeforeClass 
	 /*public void initialise(RepresentativeServiceImpl representativeServiceImpl) {
		 this.representativeServiceImpl=representativeServiceImpl; 
		 }
		 */
	 @Mock
	AuthClient authClient;
	 
	@Mock
	DoctorRepo doctorRepo;
	
	@Mock
	MedicalRepService medicalRepService;
	
	@Mock
	StockFeignClient stockFeignClient;
	
	@Test
	public void TestlistSchedule() {
		
		Doctor d=new Doctor(1,"D1","9884122113","Orthopaedics");
		List<MedicalRep> medicalRep=new ArrayList<>();
		medicalRep.add(new MedicalRep("R1","9874563210"));
		List<String> med= new ArrayList<>();
		med.add("Orthoherb");med.add("Cholecalciferol");
		when(doctorRepo.getOne(1)).thenReturn(d);
		when(doctorRepo.count()).thenReturn(1L);
		when(medicalRepService.sendRep()).thenReturn(medicalRep);
		when(stockFeignClient.getMedicineByTreatingAilment("Orthopaedics")).thenReturn(med);
		assertNotNull(representativeServiceImpl.listschedule("2021-07-21"));
	}
	
	@Test
	public void TestStringtoDate() {
		LocalDate dt=LocalDate.parse("2021-07-19");
		assertEquals(dt,representativeServiceImpl.stringToDate("2021-07-19"));
	}
	
	@Test
	public void TestListOfDate() {
		LocalDate dt=LocalDate.parse("2021-07-19");
		String date[]= {"2021-07-19","2021-07-20","2021-07-21","2021-07-22","2021-07-23"};
		assertArrayEquals(date,representativeServiceImpl.getListOfDates(dt));
	}
	
	@Test
	public void TestIsSessionValid() {
		AuthResponse auth=new AuthResponse("admin","admin",true);
		when(authClient.getValidity("token")).thenReturn(auth);
		
		assertEquals(true,representativeServiceImpl.isSessionValid("token"));
	}
}
