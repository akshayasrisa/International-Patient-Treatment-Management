package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PackageDetail {

	private Long packagedetailId;

	private String name;

	private double cost;

	private String testdetails;

	private int treatmentduration;

	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getTestdetails() {
		return testdetails;
	}

	public void setTestdetails(String testdetails) {
		this.testdetails = testdetails;
	}

	public int getTreatmentduration() {
		return treatmentduration;
	}

	public void setTreatmentduration(int treatmentduration) {
		this.treatmentduration = treatmentduration;
	}

	public Long getPackagedetailId() {
		return packagedetailId;
	}

	public void setPackagedetailId(Long packagedetailId) {
		this.packagedetailId = packagedetailId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}