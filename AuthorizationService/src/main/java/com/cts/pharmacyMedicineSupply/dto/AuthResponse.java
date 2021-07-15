package com.cts.pharmacyMedicineSupply.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {

	private String uid;

	private String name;

	private boolean isValid;

}
