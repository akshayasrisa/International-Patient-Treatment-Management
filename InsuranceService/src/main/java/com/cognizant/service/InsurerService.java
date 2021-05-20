/*

package com.cognizant.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.model.InsurerDetail;

import com.cognizant.repository.InsurerRepository;


public class InsurerService {
	
	@Autowired
	InsurerRepository insurerRepository;
	
	//returns list of insurers base on a given name
	public List<InsurerDetail> getInsurersByInsurancePackageName(String insurerPackageName) {
	    List<InsurerDetail> insurerdetails  = new ArrayList<>();
		   
	    insurerRepository.findByInsurerPackageName(insurerPackageName)
	    .forEach(insurerdetails::add);
		   
	    return insurerdetails;
	}
}
*/