package com.cognizant.fiegn;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.model.PackageDetail;
import com.cognizant.model.SpecialistDetail;

@FeignClient(name = "IPTOService", url = "http://team1iptoservice-env.eba-skyhg5mw.eu-west-2.elasticbeanstalk.com/")
public interface TreatmentFeignClient {

	@GetMapping("/api/packagedetails")
	public List<PackageDetail> getPackageDetails();

	@RequestMapping(value = "/api/IPTOService/packagedetails/name/{name}")
	public List<PackageDetail> getPackageDetailByName(@PathVariable String name);

	@GetMapping("/api/IPTOService/api/packagedetails/{packagedetailId}")
	public PackageDetail getPackageDetail(@PathVariable(name = "packagedetailId") Long packagedetailId);

	@GetMapping("/api/IPTOService/api/findByNameAndPackage/{name}/{category}")
	public PackageDetail getPackageByBoth(@PathVariable(name = "name") String name,
			@PathVariable(name = "category") String category);

	@PostMapping("/api/IPTOService/api/packagedetails")
	public void savePackageDetail(@RequestBody PackageDetail packagedetail);

	@DeleteMapping("/api/IPTOService/api/packagedetails/{packagedetailId}")
	public void deletePackageDetail(@PathVariable(name = "packagedetailId") Long packagedetailId);

	@PutMapping("/api/IPTOService/api/packagedetails/{packagedetailId}")
	public void updatePackageDetail(@RequestBody PackageDetail packagedetail,
			@PathVariable(name = "packagedetailId") Long packagedetailId);
	
	
	@GetMapping("/api/IPTOService/api/specialistdetails")
	public List<SpecialistDetail> getSpecialistDetails() ;

	@GetMapping("/api/IPTOService/api/byDomain/{domain}/{pkg}")
	public SpecialistDetail byDomain(@PathVariable String domain, @PathVariable String pkg);

	@GetMapping("/api/IPTOService/api/specialistdetails/{specialistdetailId}")
	public SpecialistDetail getSpecialistDetail(@PathVariable(name = "specialistdetailId") Long specialistdetailId) ;
	

}