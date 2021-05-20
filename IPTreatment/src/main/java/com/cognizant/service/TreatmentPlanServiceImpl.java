package com.cognizant.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.fiegn.TreatmentFeignClient;
import com.cognizant.model.PackageDetail;
import com.cognizant.model.Patient;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.repository.PatientRepository;
import com.cognizant.repository.TreatmentPlanRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TreatmentPlanServiceImpl {

	@Autowired
	private TreatmentPlanRepository treatmentplanRepository;

	@Autowired
	private TreatmentFeignClient feignClient;

	@Autowired
	private PatientRepository patientRepository;

	public TreatmentPlan getPlan(String name, int age, String ailment, String pkg, String date) throws ParseException {
		PackageDetail packageDetail = findByNameAndCategory(pkg, ailment);
		SpecialistDetail doc = findTheDoc(ailment, pkg);

		Patient patient = new Patient(name, age, ailment, pkg, date);
		patientRepository.save(patient);

		TreatmentPlan plan = new TreatmentPlan();
		plan.setPackagename(pkg);

		plan.setCost(packageDetail.getCost());
		plan.setStartdate(date);

		Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
		int noOfDays = 7 * packageDetail.getTreatmentduration(); // i.e two weeks
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_YEAR, noOfDays);
		Date enddate = calendar.getTime();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = dateFormat.format(enddate);

		plan.setEnddate(strDate);

		plan.setStatus(false);

		plan.setSpecialist(doc.getName());
		plan.setTestdetails(packageDetail.getTestdetails());

		plan.setPatient(patient);

		treatmentplanRepository.save(plan);
		return plan;

	}

	public PackageDetail findByNameAndCategory(String pkg, String category) {
//		String url = "http://localhost:8080/api/findByNameAndPackage/" + pkg + "/" + category;
//
//		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<PackageDetail> entity = restTemplate.getForEntity(url, PackageDetail.class);
		PackageDetail packageDetail = feignClient.getPackageByBoth(pkg, category);

		return packageDetail;
	}

	public SpecialistDetail findTheDoc(String domain, String pkg) {
		// String url = "http://localhost:8080/api/byDomain/" + domain + "/" + pkg;

		// RestTemplate restTemplate = new RestTemplate();
		// ResponseEntity<SpecialistDetail> entity = restTemplate.getForEntity(url,
		// SpecialistDetail.class);
		// SpecialistDetail specialist = entity.getBody();
		SpecialistDetail specialist = feignClient.byDomain(domain, pkg);
		return specialist;
	}
}
