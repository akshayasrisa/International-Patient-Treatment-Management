package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.PackageDetail;
import com.cognizant.model.Patient;
import com.cognizant.model.SpecialistDetail;
import com.cognizant.portal.feign.IPTOFeignClient;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@Slf4j
@RestController
public class PackageController {

	@Autowired
	private PortalService portalService;

	@RequestMapping("/packagedetails")
	@ResponseBody
	public ModelAndView getPackageDetail(HttpSession session) {
		log.info("Start---------inside ");
		String token = (String)(session.getAttribute("token"));

		List<PackageDetail> packagedetailList = portalService.getPackageDetail(token);
		// List<PackageDetail> packagedetailList = (List<PackageDetail>)
		// packagedetailList.getBody();
		System.out.println(packagedetailList.toString());
		ModelAndView modelAndView = new ModelAndView("packagedetailList");
		modelAndView.addObject("packagedetailList", packagedetailList);
		return modelAndView;
	}
}
