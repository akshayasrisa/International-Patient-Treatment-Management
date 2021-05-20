package com.cognizant.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.TreatmentPlan;

	public interface TreatmentPlanRepository extends JpaRepository<TreatmentPlan, Long> {
		
	}