package com.cognizant.portal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;



@FeignClient(url = "http://team1insuranceclaimservice-env.eba-qu7m2pje.eu-west-2.elasticbeanstalk.com/", name = "InsuranceService")
public interface InsuranceFeignClient {

	@GetMapping("/api/InsuranceService/initiateClaim/{treatment_id}")
	public int initiateClaim(@RequestHeader(name = "Authorization") String token, @PathVariable int treatment_id);
	
	
}
