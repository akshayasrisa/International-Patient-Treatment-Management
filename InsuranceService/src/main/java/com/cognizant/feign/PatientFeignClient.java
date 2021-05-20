package com.cognizant.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.model.TreatmentPlan;

@FeignClient(name = "IPTreatment", url = "http://team1iptreatmentservice-env.eba-memm5en2.eu-west-2.elasticbeanstalk.com/")
public interface PatientFeignClient {
	
	
	@GetMapping("/api/IPTreatment/getTreatmentPlan/{id}")
	public TreatmentPlan getPatientById(@PathVariable long id);

}