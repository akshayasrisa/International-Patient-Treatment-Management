package com.cognizant.portal.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.PackageDetail;
import com.cognizant.model.SpecialistDetail;



@FeignClient(url = "http://team1iptoservice-env.eba-skyhg5mw.eu-west-2.elasticbeanstalk.com/", name = "IPTOService")
public interface IPTOFeignClient {

	
@GetMapping("/api/IPTOService/api/specialistdetails")
public List<SpecialistDetail> getSpecialistDetail(@RequestHeader(name = "Authorization") String token);


@GetMapping("/api/IPTOService/api/packagedetails")
public List<PackageDetail> getPackageDetail(@RequestHeader(name = "Authorization") String token);
}
