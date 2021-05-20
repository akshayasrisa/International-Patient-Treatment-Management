package com.cognizant.portal.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.model.Patient;
import com.cognizant.model.TreatmentPlan;

@FeignClient(url = "http://team1iptreatmentservice-env.eba-memm5en2.eu-west-2.elasticbeanstalk.com/", name = "IPTreatment")
public interface IPTFeignClient {

	@GetMapping("/api/IPTreatment/plan/{name}/{age}/{aliment}/{pkg}/{date}")
	public TreatmentPlan plan(@PathVariable String name, @PathVariable int age, @PathVariable String aliment,
			@PathVariable String pkg, @PathVariable String date);

	/*@GetMapping("/api/IPTreatment/status")
	public String planed();

	@GetMapping("/api/IPTreatment/changeStatus/{id}")
	public void changeStatus(@PathVariable Long id);

	*/
	
	@GetMapping("status")
	public String planed();

	@GetMapping("/api/IPTreatment/changeStatus/{id}")
	public void changeStatus(@PathVariable Long id);
	
	//treatment plan
	@GetMapping("/api/IPTreatment/getTreatmentPlanList")
	public List<TreatmentPlan> getTreatmentPlanList(@RequestHeader(name = "Authorization") String token);
	
	@GetMapping("/api/IPTreatment/getPatientList")
	public List<Patient> getPatientList();
	
	

}
