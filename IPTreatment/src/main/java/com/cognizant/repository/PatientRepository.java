package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
