package com.cognizant.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
public class TreatmentPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	long id;
	String packagename; // common for one transaction

	String testdetails;
	String specialist;

	double cost;
	String startdate;
	String enddate;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	Patient patient;

	boolean status;

}
