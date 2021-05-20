package com.cognizant.service;

import java.util.List;

import com.cognizant.exceptions.SpecialistDetailNotPresentException;

import com.cognizant.model.TreatmentPlan;
import com.cognizant.model.TreatmentPlanEntry;

public interface TreatmentPlanService {

	List<TreatmentPlanEntry> getAllDetails() throws SpecialistDetailNotPresentException;

}
