package com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.feingclient.AuthClient;
import com.cts.pharmacymedicinesupplymanagementsystem.pharmacysupplymodule.model.PharmacyMedicineSupply;


@Service
public class PharmacyMedicineSupplyService {
	@Autowired
	private AuthClient authClient;
	
	private static List<PharmacyMedicineSupply> pharmacyList = new ArrayList<>();
	
    
    public List<PharmacyMedicineSupply> retrievePharmacies(String token,int demand,String medicine, int stock) {
    	String medName;
    	int supply=0;
    	boolean isvalid=isSessionValid(token);
    	if (isvalid) 
    	{	
    		pharmacyList.clear();
	    	if (demand>stock) 
	    	{
	    		supply=stock/5;
	    	}
	    	else 
	    	{
	    		supply=demand/5;
	    	}
	    	medName = medicine;
	    	pharmacyList.add(new PharmacyMedicineSupply("MedCity",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Med 7",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("PharmaOne",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("MediLane",medName,supply));
	    	pharmacyList.add(new PharmacyMedicineSupply("Pharma Plus",medName,supply));
	    	return pharmacyList;

    	}
    	
    	return new ArrayList<>();
    
    }

    public Boolean isSessionValid(String token) {
    	try {
    		authClient.getValidity(token);
    	} catch (Exception e) {
    		return false;
    	}
    	return true;
    }
    	
   
}

