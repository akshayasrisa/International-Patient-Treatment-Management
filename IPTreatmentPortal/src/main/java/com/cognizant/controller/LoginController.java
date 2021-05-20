package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Patient;
import com.cognizant.model.TreatmentPlan;
import com.cognizant.model.UserLoginCredential;
import com.cognizant.model.UserToken;
import com.cognizant.portal.feign.AuthFeignClient;
import com.cognizant.portal.feign.IPTFeignClient;

import com.cognizant.portal.feign.InsuranceFeignClient;
import com.cognizant.service.AuthFeignService;
import com.cognizant.service.PortalService;

import lombok.extern.slf4j.Slf4j;

/**
 * This class is handling all the end points for login. This controller has
 * mappings which will be used to redirect the user to the login and home page.
 * 
 * @version 1.8
 * @author Pod3
 */
@Slf4j
@Controller
@RequestMapping("/user")
public class LoginController {

	/**
	 * Used to call the method present in {@link AuthFeignClient} interface
	 */
	@Autowired
	private AuthFeignClient authFeignClient;

	@Autowired
	private IPTFeignClient ipttClient;

	@Autowired
	private PortalService portalService;

	@Autowired
	InsuranceFeignClient initiateClaim;
	/**
	 * Used to call the method present in {@link StockFeignClient} interface
	 */

	/**
	 * Used to call the method present in {@link AuthFeignService} class
	 */
	@Autowired
	private AuthFeignService feignService;

	/**
	 * This method will redirect to the login page and we are sending model
	 * attribute {@link UserLoginCredential} which will be used to bind the jsp page
	 * fields to this model attribute.
	 * 
	 * @param usercredentials
	 * @param bindingresult
	 * @return login.jsp page
	 */
	@GetMapping("/login")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult) {

		ModelAndView modelAndView = new ModelAndView("login");
		modelAndView.addObject("loginMessage", "Please Login");
		return modelAndView;
	}

	@RequestMapping("user/login")
	public String mapAdminLogin() {
		return "user/login";
	}

	@RequestMapping("/home")
	public String firstPage() {
		return "home";
	}

	@RequestMapping("registration")
	public String registrationPage() {
		return "registration";
	}

	@RequestMapping("adminhome")
	public String adminHomePage() {
		return "homepage";
	}

	@RequestMapping("patients")
	public String patientsPage(ModelMap map) {
		List<Patient> patients = ipttClient.getPatientList();
		map.put("patients", patients);
		return "patients";
	}

	@RequestMapping("/user/patient")
	public String patientPage() {
		return "user/patients";
	}

	@RequestMapping("/user/specialist")
	public String specialistPage() {
		return "user/specialistdetailList";
	}

	@RequestMapping("/user/treatmentpackages")
	public String packagePage() {
		return "user/packagedetailList";
	}

	@RequestMapping("/registerPatient")
	public String registerPatient(@PathParam("id") int id, @PathParam("name") String name, @PathParam("age") int age,
			@PathParam("ailment") String ailment, @PathParam("pkg") String pkg, @PathParam("date") String date) {

		TreatmentPlan plan = ipttClient.plan(name, age, ailment, pkg, date);
		System.out.println(date);
		return "redirect:/user/showRegisteredPatients";
	}

	@RequestMapping("/showPatients")
	public String getTreatmentPlanList(HttpSession session, ModelMap map) {
		String token = (String) (session.getAttribute("token"));
		List<TreatmentPlan> treatmentPlanList = portalService.getTreatmentPlanList(token);
		map.put("treatmentplans", treatmentPlanList);

		return "treatmentplan";
	}
	
	
	@RequestMapping("initiateClaim/{id}")
	public String initiateClaim(HttpSession session, @PathVariable int id, ModelMap map) {
		String token = String.valueOf(session.getAttribute("token"));
		int claim = portalService.initiateClaim(token, id);
		map.put("amount", claim);
		return "balanceamount";

	}

	

	@RequestMapping("/showRegisteredPatients")
	public String showPatientsList(ModelMap map) {

		List<Patient> patients = ipttClient.getPatientList();
		map.put("patients", patients);
		System.out.println(patients.get(0).getTreatmentCommencementDate());

		return "patients";
	}
	


	/**
	 * This method will return the homepage if the user login credentials are
	 * correct otherwise redirect to the login page only by displaying message as
	 * bad credentials which we are binding in the {@link ModelAndView} type object
	 * 
	 * @param usercredentials
	 * @param bindingresult
	 * @param session
	 * @return homepage.jsp
	 */
	@PostMapping("/homepage")
	public ModelAndView userLogin(@ModelAttribute("usercredentials") UserLoginCredential usercredentials,
			BindingResult bindingresult, HttpSession session) {

		log.debug("username{}: ", usercredentials.getUserid());
		ResponseEntity<?> response = null;

		try {
			response = feignService.getToken(usercredentials);
		} catch (Exception e) {
			log.error("Invalid credentials");
			ModelAndView modelAndView = new ModelAndView("login");
			modelAndView.addObject("loginMessage", "bad credentials");
			return modelAndView;
		}

		log.debug("Response{}: ", response);
		log.info("Getting body from response entity");

		UserToken userToken = (UserToken) response.getBody();

		log.debug("token{}:", userToken.getAuthToken());
		log.debug("userToken{}: ", userToken);

		session.setAttribute("token", userToken.getAuthToken());

		log.debug("session{}:", session.toString());

		ModelAndView modelAndView = new ModelAndView("homepage");
		return modelAndView;

	}

	/**
	 * Will redirect to the logout page
	 * 
	 * @return logout.jsp
	 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("token", null);
		return "home";
	}

}
