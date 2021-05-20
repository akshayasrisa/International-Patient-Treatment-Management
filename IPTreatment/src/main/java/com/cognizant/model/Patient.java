package com.cognizant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String ailment;
	private String treatmentPackageName;
	private String treatmentCommencementDate;


	public Patient(String name, int age, String ailment, String treatmentPackageName, String treatementCommencementDate) {

		this.name = name;
		this.age = age;
		this.ailment = ailment;
		this.treatmentPackageName = treatmentPackageName;
		this.treatmentCommencementDate = treatementCommencementDate;
	}

}
