

/*

package com.cognizant.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.TreatmentPlan;
import com.cognizant.model.SpecialistDetail;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.net.URI;


@RestController
public class FormulateTimeTable {
	
	
	@Autowired
	SpecialistDetail specialistDetail;
	
	@Autowired 
	TreatmentPlan patientDetails;

	@GetMapping("/specialistdetails")
	public String getSpecialistDetails() throws RestClientException, IOException {

		String baseUrl = "Http://localhost:8080/api/specialistdetails";

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<SpecialistDetail> response = null;
		try {
			response = restTemplate.getForEntity(baseUrl, SpecialistDetail.class);
					

		} catch (Exception ex) {
			System.out.println(ex);

		}
        SpecialistDetail specialistDetail = response.getBody();
		return response.getBody().toString();
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}
*/