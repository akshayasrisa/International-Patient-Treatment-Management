package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.TokenValidationFailedException;
import com.cognizant.feign.AuthFeignClient;
import com.cognizant.feign.PatientFeignClient;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.InsurerDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.repository.InsurerRepository;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class InsurerController {

	@Autowired
	private InsurerRepository insurerRepository;

	@Autowired

	private PatientFeignClient feignclient;

	@Autowired
	private AuthFeignClient authFeignClient;

	@GetMapping("/GetAllInsurerDetail")
	public List<InsurerDetail> getInsurerDetails() {
		List<InsurerDetail> insurerdetails = insurerRepository.findAll();
		return insurerdetails;
	}

	@GetMapping("/findByInsurerPackageName/{insurerPackageName}")
	public InsurerDetail getPackage(@PathVariable(name = "insurerPackageName") String insurerPackageName) {
		return insurerRepository.findByInsurerPackageName(insurerPackageName);
	}

	@GetMapping("/initiateClaim/{treatment_id}")
	public int initiateClaim(@RequestHeader(name = "Authorization") String token, @PathVariable int treatment_id) {
		log.info("Inside Insurance Claim");
		log.info("Start");
		log.debug("token{}:", token);
		int amount = 0;

		try {

			AuthResponse authResponse = authFeignClient.verifyToken(token);
			if (authResponse.isValid()) {
				log.info("Token is valid");
				// Random random = new Random(6);
				int min = 1001;
				int max = 1005;
				System.out.println("Random value of type double between " + min + " to " + max + ":");
				double a = Math.random() * (max - min + 1) + min;

				int b = (int) (Math.random() * (max - min + 1) + min);

				Optional<InsurerDetail> insurer = insurerRepository.findById(b);

				TreatmentPlan patientById = feignclient.getPatientById(treatment_id);

				amount = (int) (patientById.getCost() - insurer.get().getInsuranceAmountLimit());

				System.out.println(patientById.getCost());
				System.out.println(insurer.get().getInsuranceAmountLimit());

			}
		} catch (FeignException e) {
			System.out.println("Token validation failed");
			throw new TokenValidationFailedException("Token Expired");
		}

		if (amount > 0) {
			return amount;
		}
		return 0;

	}
}
