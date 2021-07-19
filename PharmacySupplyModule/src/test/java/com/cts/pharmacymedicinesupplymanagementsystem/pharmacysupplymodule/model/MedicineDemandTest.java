package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicineDemandTest {

	Medicine medicine;
	MedicineDemand medicineDemand;
	MedicineDemand medDemAllArg;
	
	@Before
	public void setup() {
		medicine = new Medicine();
		medicine.setName("Orthoherb");
		medicine.setNumberOfStock(8000);
		medicine.setChemicalComposition("Eranda");
		medicine.setDateOfExpiry(LocalDate.parse("2021-07-30"));
		medicine.setTargetAilment("Orthopaedics");
		medicineDemand = new MedicineDemand();
		medicineDemand.setMedicine("Orthoherb");
		medicineDemand.setDemandCount(8000);
		medDemAllArg = new MedicineDemand("Orthoherb",8000);
		
	}

	@Test
	public void testMedicineDetails() {
		assertEquals("Orthoherb",medicine.getName());
		assertEquals(8000, medicine.getNumberOfStock());
		assertEquals("Eranda", medicine.getChemicalComposition());
		assertEquals(LocalDate.parse("2021-07-30"), medicine.getDateOfExpiry());
		assertEquals("Orthopaedics", medicine.getTargetAilment());
		assertEquals("Orthoherb", medicineDemand.getMedicine());
		assertEquals(8000,medicineDemand.getDemandCount());
		String medDemandString = String.format(
                "MedicineDemand [medicine=%s, demandCount=%d]",
                medicineDemand.getMedicine(), medicineDemand.getDemandCount());
		assertEquals(medDemandString, medicineDemand.toString());
	}
	
	@Test
	public void testToString() {
		String val=medicine.toString();
		//String printMed = "Medicine [name=" + medicine.getName() + ", chemicalComposition=" + medicine.getChemicalComposition() + ", targetAilment="
		//		+ medicine.getTargetAilment() + ", dateOfExpiry=" + medicine.getDateOfExpiry() + ", numberofstock=" + medicine.getNumberOfStock() + "]";
		assertEquals(val,medicine.toString());
	}
	
	@Test
	public void testhashcode() {
		Medicine m=new Medicine();
		medicine=new Medicine();
		assertEquals(medicine.equals(m),m.equals(medicine));
		assertNotNull(m.hashCode());
		assertNotNull(medicine.hashCode());
	}
}
