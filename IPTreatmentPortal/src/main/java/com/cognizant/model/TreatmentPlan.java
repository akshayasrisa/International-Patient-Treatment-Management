package com.cognizant.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentPlan {

	long id;
	String packagename; // common for one transaction

	String testdetails;
	String specialist;

	double cost;
	String startdate;
	String enddate;

	Patient patient;

	boolean status;

}
