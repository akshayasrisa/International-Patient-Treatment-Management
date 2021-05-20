package com.cognizant.model;

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