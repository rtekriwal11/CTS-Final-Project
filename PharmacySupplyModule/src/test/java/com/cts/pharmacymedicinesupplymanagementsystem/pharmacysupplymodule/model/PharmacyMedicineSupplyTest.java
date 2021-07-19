package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class PharmacyMedicineSupplyTest {


	PharmacyMedicineSupply pharmacyMedicineSupply;
	PharmacyMedicineSupply pharmacyMedicineSupplyDefault;
	
	@Before
	public void setUp() {
		pharmacyMedicineSupply = new PharmacyMedicineSupply("pharName", "medName", 8000);
	}

	@Test
	public void test() {
		assertEquals("pharName", pharmacyMedicineSupply.getPharmacyName());
		pharmacyMedicineSupply.setPharmacyName("newPharName");
		assertEquals("newPharName", pharmacyMedicineSupply.getPharmacyName());
		assertEquals("medName", pharmacyMedicineSupply.getMedicineName());
		pharmacyMedicineSupply.setMedicineName("newMedName");
		assertEquals("newMedName", pharmacyMedicineSupply.getMedicineName());
		assertEquals(8000, pharmacyMedicineSupply.getSupplyCount());
		pharmacyMedicineSupply.setSupplyCount(9000);
		assertEquals(9000, pharmacyMedicineSupply.getSupplyCount());
		String pharToString = String.format(
                "PharmacyMedicineSupply [pharmacyName=%s, medicineName=%s, supplyCount=%d]", pharmacyMedicineSupply.getPharmacyName(),
                pharmacyMedicineSupply.getMedicineName(), pharmacyMedicineSupply.getSupplyCount());
		assertEquals(pharToString, pharmacyMedicineSupply.toString());
	}
	@Test
	public void testhashcode() {
		PharmacyMedicineSupply pharmacyMedicineSupplyD=new PharmacyMedicineSupply("medName", "pharName", 8000);
		assertEquals(pharmacyMedicineSupply.equals(pharmacyMedicineSupplyD),pharmacyMedicineSupplyD.equals(pharmacyMedicineSupply));
		assertNotNull(pharmacyMedicineSupply.hashCode());
		assertNotNull(pharmacyMedicineSupplyD.hashCode());
	}
}
