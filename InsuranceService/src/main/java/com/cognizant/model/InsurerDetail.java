package com.cognizant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "insurerdetails")
public class InsurerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int InsurerId;
	
	@Column(name = "insurername", nullable = false)
	private String insurerName;
	
	@Column(name = "insurerpackagename", nullable = false)
	private String insurerPackageName;
	
	@Column(name = "insureramountlimit", nullable = false)
	private Long insuranceAmountLimit;
	
	@Column(name = "disbursementduration", nullable = false)
	private int disbursementDuration;

	public int getInsurerId() {
		return InsurerId;
	}

	public void setInsurerId(int insurerId) {
		InsurerId = insurerId;
	}

	public String getInsurerName() {
		return insurerName;
	}

	public void setInsurerName(String insurerName) {
		this.insurerName = insurerName;
	}

	public String getInsurerPackageName() {
		return insurerPackageName;
	}

	public void setInsurerPackageName(String insurerPackageName) {
		this.insurerPackageName = insurerPackageName;
	}

	public Long getInsuranceAmountLimit() {
		return insuranceAmountLimit;
	}

	public void setInsuranceAmountLimit(Long insuranceAmountLimit) {
		this.insuranceAmountLimit = insuranceAmountLimit;
	}

	public int getDisbursementDuration() {
		return disbursementDuration;
	}

	public void setDisbursementDuration(int disbursementDuration) {
		this.disbursementDuration = disbursementDuration;
	}
}

	
	

	