package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.MedicalRep;
import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.service.MedicalRepService;

@ExtendWith(MockitoExtension.class)
public class MedicalRepServiceTest {
	
	@InjectMocks
	MedicalRepService medicalRepService;
	
	 @BeforeClass public void initialise(MedicalRepService medicalRepService) {
	 this.medicalRepService=medicalRepService; 
	 }
	
	@Test
	public void TestsendRep() {
		List<MedicalRep> medicalRep=new ArrayList<>();
		medicalRep.add(new MedicalRep("R1","9874563210"));
		medicalRep.add(new MedicalRep("R2","9874563210"));
		medicalRep.add(new MedicalRep("R3","9874563210"));
		assertEquals(medicalRep,medicalRepService.sendRep());
	}

}
