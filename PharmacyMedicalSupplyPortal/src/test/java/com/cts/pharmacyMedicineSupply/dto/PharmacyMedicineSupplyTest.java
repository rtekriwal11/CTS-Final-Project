package com.cts.pharmacyMedicineSupply.dto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PharmacyMedicineSupplyTest {
PharmacyMedicineSupply pharmacyMedicineSupply;
	
	@BeforeEach
	public void setup() {
		//doctor=new Doctor(0,"D1","9884122113","Orthopaedics");
		pharmacyMedicineSupply=new PharmacyMedicineSupply("Med7", "Orthoherb", 8000);
	}
	
	@Test
	public void testmethods() {
		assertEquals("Med7",pharmacyMedicineSupply.getPharmacyName());
		assertEquals("Orthoherb",pharmacyMedicineSupply.getMedicineName());
		assertEquals(8000,pharmacyMedicineSupply.getSupplyCount());
	}
	
	@Test
	public void testsetter() {
		pharmacyMedicineSupply.setMedicineName("Medi7");
		pharmacyMedicineSupply.setPharmacyName("Orthoherbo");
		pharmacyMedicineSupply.setSupplyCount(8500);
		assertEquals("Orthoherbo",pharmacyMedicineSupply.getPharmacyName());
		assertEquals("Medi7",pharmacyMedicineSupply.getMedicineName());
		assertEquals(8500,pharmacyMedicineSupply.getSupplyCount());
	}
	
	@Test
	public void teststring() {
		String val=pharmacyMedicineSupply.toString();
		assertEquals(val, pharmacyMedicineSupply.toString());
	}
}
