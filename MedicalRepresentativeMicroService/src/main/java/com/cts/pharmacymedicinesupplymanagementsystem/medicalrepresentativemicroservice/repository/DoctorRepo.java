package com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.pharmacymedicinesupplymanagementsystem.medicalrepresentativemicroservice.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Integer>{

}
