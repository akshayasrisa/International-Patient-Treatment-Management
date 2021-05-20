package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.model.SpecialistDetail;

public interface SpecialistDetailRepository extends JpaRepository<SpecialistDetail, Long> {

	@Query("FROM SpecialistDetail d WHERE d.domain = :domain and d.experienceinyears <=5")
	List<SpecialistDetail> findByJr(String domain);

	@Query("FROM SpecialistDetail d WHERE d.domain = :domain and d.experienceinyears >5")
	List<SpecialistDetail> findBySr(String domain);

}
