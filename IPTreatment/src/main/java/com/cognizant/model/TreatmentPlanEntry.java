package com.cognizant.model;



import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TreatmentPlanEntry {

	String packagename; //common for one transaction
	String testdetails;
	double cost;
	
	

}
