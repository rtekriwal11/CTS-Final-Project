package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model;
//H2 DB ALWAYS GENERATE DATA IN ALPHABETICAL ORDER

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
	@Id
	@GeneratedValue
	private int id;
	private String doctorname;
	private String contactnumber;
	private String treatingailment;
}
