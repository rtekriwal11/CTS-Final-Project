package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.controller;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.controller.PharmacySupplyModuleController;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.feingclient.AuthClient;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.feingclient.StockFeignClient;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model.AuthResponse;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.service.PharmacyMedicineSupplyService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class contains test cases for the MedicineSupplyController class which
 * are written using Junit and Mockito
 */
@Slf4j
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest

public class PharmacySupplyModuleControllerTest {
	
	@InjectMocks
	private PharmacySupplyModuleController medicineSupplyController;
	
	@Mock
	private StockFeignClient stockClient;
	
	
	
	@Mock
	private PharmacyMedicineSupplyService pharmacyService;
	
	
	/**
	 * @throws Exception  Tests the showList method and checks if
	 *  						the returned value is null or not
	 */
	@Test
	public void testShowList() throws Exception{
	when(pharmacyService.isSessionValid("token")).thenReturn(true);
	ResponseEntity<?> responseEntity = medicineSupplyController.showList("token","OrthoHerb", 500);
	stockClient.getStockCountForMedicine("OrthoHerb");
	HttpStatus status = responseEntity.getStatusCode();
	assertNotNull(status);
	assertEquals(HttpStatus.OK,status);
	
	}
}
