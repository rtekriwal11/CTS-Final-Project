package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.feingclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(url="http://localhost:8080/stock", name="stockMedicine")
@FeignClient(url="ij021-pod3-lb-1742857365.us-east-2.elb.amazonaws.com/stock", name="stockMedicine")
public interface StockFeignClient {

	@GetMapping(value="/get-stock-count/{medicine}")
	public int getStockCountForMedicine(
			@PathVariable("medicine") String medicine);

	@GetMapping("/update-stock/{medicine}/{count}")
	public Boolean updateNumberOfTabletsInStockByName(
			@PathVariable("medicine") String medicine, @PathVariable("count") int count);

	
}
