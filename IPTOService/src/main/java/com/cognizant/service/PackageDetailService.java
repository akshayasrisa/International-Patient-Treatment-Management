package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.PackageDetail;
import com.cognizant.repository.PackageDetailRepository;

@Service
public class PackageDetailService {
	
	@Autowired
	PackageDetailRepository packagedetailRepository;
	
	//returns list of packagedetails base on a given name
	public List<PackageDetail> getPackageDetailsByName(String name) {
	    List<PackageDetail> packagedetails  = new ArrayList<>();
		   
	    packagedetailRepository.findByName(name)
	    .forEach(packagedetails::add);
		   
	    return packagedetails;
	}
}

