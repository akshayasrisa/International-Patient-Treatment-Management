package com.cognizant.model;

import lombok.Data;

@Data
public class InitiateClaim {

	int patient;
	String ailment;
	String treatmentPackageName;
	int insurer;

}
