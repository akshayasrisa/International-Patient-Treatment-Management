package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.SpecialistDetail;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/user")
@Slf4j
@RestController
public class SpecialistController {

	@Autowired
	private PortalService portalService;

	@RequestMapping("/specialistdetails")
	@ResponseBody
	public ModelAndView getSpecialistDetail(HttpSession session) {
		log.info("Start---------inside ");
		String token = (String) session.getAttribute("token");

		List<SpecialistDetail> specialistdetailList = portalService.getSpecialistDetail(token);

		ModelAndView modelAndView = new ModelAndView("specialistdetailList");
		modelAndView.addObject("specialistdetailList", specialistdetailList);
		return modelAndView;
	}

}
