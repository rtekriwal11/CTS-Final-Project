package com.cognizant.stockMedicineService.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class MedicineTest {

	Medicine medicine;
	
	@Before
	public void setup() {
		medicine = new Medicine();
		medicine.setName("Orthoherb");
		medicine.setNumberOfStock(8000);
		medicine.setChemicalComposition("Eranda");
		medicine.setDateOfExpiry(LocalDate.parse("2021-07-30"));
		medicine.setTargetAilment("Orthopaedics");
	}

	@Test
	public void testMedicineDetails() {
		assertEquals("Orthoherb",medicine.getName());
		assertEquals(8000, medicine.getNumberOfStock());
		assertEquals("Eranda", medicine.getChemicalComposition());
		assertEquals(LocalDate.parse("2021-07-30"), medicine.getDateOfExpiry());
		assertEquals("Orthopaedics", medicine.getTargetAilment());
	}
	
	@Test
	public void testToString() {
		String printMed = "Medicine [name=" + medicine.getName() + ", chemicalComposition=" + medicine.getChemicalComposition() + ", targetAilment="
				+ medicine.getTargetAilment() + ", dateOfExpiry=" + medicine.getDateOfExpiry() + ", numberofstock=" + medicine.getNumberOfStock() + "]";
		assertEquals(printMed,medicine.toString());
	}
}
