package com.cognizant.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PackageDetail;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.portal.feign.IPTFeignClient;
import com.cognizant.portal.feign.IPTOFeignClient;
import com.cognizant.portal.feign.InsuranceFeignClient;

@Service
public class PortalService {

	@Autowired
	private IPTOFeignClient iptofeignclient;

	@Autowired
	private IPTFeignClient iptfeignclient;

	@Autowired
	InsuranceFeignClient initiateClaim;

	public List<SpecialistDetail> getSpecialistDetail(String token) {

		List<SpecialistDetail> specialistDetail = iptofeignclient.getSpecialistDetail(getTokenWithHeader(token));
		return specialistDetail;
	}

	public List<PackageDetail> getPackageDetail(String token) {
		List<PackageDetail> packageDetail = iptofeignclient.getPackageDetail(getTokenWithHeader(token));
		return packageDetail;
	}
	
	public List<TreatmentPlan> getTreatmentPlanList(String token){
		List<TreatmentPlan> treatmentPlan = iptfeignclient.getTreatmentPlanList(getTokenWithHeader(token));
		return treatmentPlan;
	}
	
	public int initiateClaim( String token,  int treatment_id) {
		int claim = initiateClaim.initiateClaim(getTokenWithHeader(token), treatment_id);
		return claim;
	}

	public String getTokenWithHeader(String token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Bearer " + token);

		return headers.getFirst("Authorization");
	}

}
