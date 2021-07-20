package com.cts.pharmacyMedicineSupply.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cts.pharmacyMedicineSupply.dto.Datedto;
import com.cts.pharmacyMedicineSupply.dto.RepSchedule;

//@FeignClient(url="localhost:8081/medicalrep", name="medicalrepresentative")
@FeignClient(url="ij021-pod3-lb-1742857365.us-east-2.elb.amazonaws.com/medicalrep", name="medicalrepresentative")
public interface MedicalRepMicroServiceFeign {

	@GetMapping("/RepSchedule")
	public List<RepSchedule> getSchedule(@RequestHeader("Authorization") String token,@RequestParam String date);

}
