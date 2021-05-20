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
public class SpecialistDetail {
	
	private long specialistdetailId;
	

	    private String name;
	 

	   private int experienceinyears;
	 

	   private String contactnumber;
	
	
	 
	 private String domain;


	public long getSpecialistdetailId() {
		return specialistdetailId;
	}


	public void setSpecialistdetailId(long specialistdetailId) {
		this.specialistdetailId = specialistdetailId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getExperienceinyears() {
		return experienceinyears;
	}


	public void setExperienceinyears(int experienceinyears) {
		this.experienceinyears = experienceinyears;
	}


	public String getContactnumber() {
		return contactnumber;
	}


	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}


	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}
	 
}

