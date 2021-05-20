package com.cognizant.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.TokenValidationFailedException;
import com.cognizant.feignclient.AuthFeignClient;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.PackageDetail;
import com.cognizant.repository.PackageDetailRepository;
import com.cognizant.service.PackageDetailService;
import lombok.extern.slf4j.Slf4j;

import feign.FeignException;

@RestController
@Slf4j
public class PackageDetailController {

	@Autowired
	private PackageDetailRepository packagedetailRepository;

	@Autowired
	private PackageDetailService packagedetailService;

	@Autowired
	private AuthFeignClient authFeignClient;

	@GetMapping("/api/packagedetails")
	public List<PackageDetail> packagedetails(@RequestHeader(name = "Authorization") String token) {
		log.info("Inside IPTOService PackageDetails");
		log.info("Start");
		log.debug("token{}:", token);

		List<PackageDetail> packagedetails = null;
		try {
			AuthResponse authResponse = authFeignClient.verifyToken(token);

			if (authResponse.isValid()) {
		    log.info("Token is valid");

				packagedetails = packagedetailRepository.findAll();
				System.out.println(packagedetails.toString());
			}
		} catch (FeignException e) {
			log.info("Token validation failed");
			throw new TokenValidationFailedException("Token Expired");
		}
		return packagedetails;
	}

	@RequestMapping(value = "/packagedetails/name/{name}")
	public List<PackageDetail> getPackageDetailByName(@RequestHeader(name = "Authorization") String token,
			@PathVariable("name") String name) {
	
		log.info("Inside IPTOService PackageDetails by name");
		log.info("Start");
		log.debug("token{}:", token);
		log.debug("Package Id -> {}:", name);

		List<PackageDetail> packageDetailByName = null;

		try {
			AuthResponse authResponse = authFeignClient.verifyToken(token);
			if (authResponse.isValid()) {
				log.info("Token is valid");
				packageDetailByName = packagedetailRepository.findByName(name);

	
				}

		} catch (FeignException e) {
			log.error("Token validation failed");
			throw new TokenValidationFailedException("Token Expired");
		}

		return  packageDetailByName;

	}


	@GetMapping("/api/packagedetails/{packagedetailId}")
	public PackageDetail getPackageDetail(@PathVariable(name = "packagedetailId") Long packagedetailId) {
		return packagedetailRepository.findById(packagedetailId).get();
	}

	@GetMapping("/api/findByNameAndPackage/{name}/{category}")
	public PackageDetail getPackageByBoth(@PathVariable(name = "name") String name,
			@PathVariable(name = "category") String category) {
		return packagedetailRepository.findByNameAndCategory(name, category);
	}

	@PostMapping("/api/packagedetails")
	public void savePackageDetail(@RequestBody PackageDetail packagedetail) {
		packagedetailRepository.save(packagedetail);
		System.out.println("PackageDetail Saved Successfully");
	}

	@DeleteMapping("/api/packagedetails/{packagedetailId}")
	public void deletePackageDetail(@PathVariable(name = "packagedetailId") Long packagedetailId) {
		PackageDetail entity = packagedetailRepository.findById(packagedetailId).get();
		packagedetailRepository.delete(entity);
		System.out.println("PackageDetail Deleted Successfully");
	}

	@PutMapping("/api/packagedetails/{packagedetailId}")
	public void updatePackageDetail(@RequestBody PackageDetail packagedetail,
			@PathVariable(name = "packagedetailId") Long packagedetailId) {
		PackageDetail emp = packagedetailRepository.findById(packagedetailId).get();
		if (emp != null) {
			packagedetailRepository.save(packagedetail);
		}

	}

}