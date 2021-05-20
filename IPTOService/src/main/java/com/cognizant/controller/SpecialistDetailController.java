package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.TokenValidationFailedException;
import com.cognizant.feignclient.AuthFeignClient;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.repository.SpecialistDetailRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SpecialistDetailController {

	@Autowired
	private SpecialistDetailRepository specialistdetailRepository;
	
	@Autowired 
	AuthFeignClient authFeignClient;

	@GetMapping("/api/specialistdetails")
	public List<SpecialistDetail> getSpecialistDetails(@RequestHeader(name = "Authorization") String token) {
		log.info("Inside IPTOService SpecialistDetails");
		log.info("Start");
		log.debug("token{}:", token);
		List<SpecialistDetail> specialistdetails = null;
		try {

			AuthResponse authResponse = authFeignClient.verifyToken(token);
			if (authResponse.isValid()) {
				System.out.println("Token is valid");
				specialistdetails = specialistdetailRepository.findAll();
			}
		} catch (FeignException e) {
			System.out.println("Token validation failed");
			throw new TokenValidationFailedException("Token Expired");
		}

		return specialistdetails;
	}

	@GetMapping("/api/byDomain/{domain}/{pkg}")
	public SpecialistDetail byDomain(@PathVariable String domain, @PathVariable String pkg) {
		List<SpecialistDetail> specialistdetails = null;
		System.out.println(pkg);
		if (pkg.equalsIgnoreCase("package1")) {
			specialistdetails = specialistdetailRepository.findByJr(domain);
		} else {
			specialistdetails = specialistdetailRepository.findBySr(domain);
		}

		return specialistdetails.get(0);
	}

	@GetMapping("/api/specialistdetails/{specialistdetailId}")
	public SpecialistDetail getSpecialistDetail(@PathVariable(name = "specialistdetailId") Long specialistdetailId) {
		return specialistdetailRepository.findById(specialistdetailId).get();
	}
}