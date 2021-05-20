package com.cognizant.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exceptions.TokenValidationFailedException;
import com.cognizant.fiegn.AuthFeignClient;
import com.cognizant.model.AuthResponse;
import com.cognizant.model.Patient;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.repository.PatientRepository;
import com.cognizant.repository.TreatmentPlanRepository;
import com.cognizant.service.TreatmentPlanServiceImpl;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TreatmentPlanController {

	@Autowired
	private TreatmentPlanServiceImpl treatmentplanService;
	@Autowired
	private TreatmentPlanRepository treatmentplanRepository;
	@Autowired
	private PatientRepository patientRepo;
	@Autowired
	private AuthFeignClient authFeignClient;

	@GetMapping("/getTreatmentPlanList")
	public List<TreatmentPlan> getTreatmentPlanList(@RequestHeader(name = "Authorization") String token) {
		log.info("Inside IPTreatment Treatmentplan");
		log.info("Start");
		log.debug("token{}:", token);
		List<TreatmentPlan> treatmentPlan = null;
		try {

			AuthResponse authResponse = authFeignClient.verifyToken(token);
			if (authResponse.isValid()) {
				log.info("Token is valid");

				treatmentPlan = treatmentplanRepository.findAll();
			}
		} catch (FeignException e) {
			System.out.println("Token validation failed");
			throw new TokenValidationFailedException("Token Expired");
		}
		return treatmentPlan;

	}

	@GetMapping("/plan/{name}/{age}/{aliment}/{pkg}/{date}")

	public TreatmentPlan plan(@PathVariable String name, @PathVariable int age, @PathVariable String aliment,
			@PathVariable String pkg, @PathVariable String date) throws ParseException {

		System.out.println(date + "line1");
		TreatmentPlan plan = treatmentplanService.getPlan(name, age, aliment, pkg, date);
		return plan;
	}

	@GetMapping("/status")
	public String planed() {

		TreatmentPlan treatmentPlan = treatmentplanRepository.findById(1l).get();

		if (treatmentPlan.isStatus()) {
			return "COMPLETED";
		}

		return "IN PROGRESS";
	}

	/*
	 * @GetMapping("/getTreatmentPlanList") public List<TreatmentPlan>
	 * getTreatmentPlanList() {
	 * 
	 * List<TreatmentPlan> treatmentPlan = treatmentplanRepository.findAll();
	 * 
	 * return treatmentPlan; }
	 */

	@GetMapping("/getPatientList")
	public List<Patient> getPatientList() {

		List<Patient> findAll = patientRepo.findAll();

		return findAll;
	}

	@GetMapping("changeStatus/{id}")
	public void changeStatus(@PathVariable Long id) {

		TreatmentPlan treatmentPlan = treatmentplanRepository.findById(id).get();
		treatmentPlan.setStatus(!treatmentPlan.isStatus());
		treatmentplanRepository.save(treatmentPlan);
}
	@GetMapping("getTreatmentPlan/{id}")
	public TreatmentPlan getPatientById(@PathVariable long id) {
		Optional<TreatmentPlan> findById = treatmentplanRepository.findById(id);

		return findById.get();
	}
}
