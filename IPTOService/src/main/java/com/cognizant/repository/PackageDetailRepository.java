package com.cognizant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.PackageDetail;

public interface PackageDetailRepository extends JpaRepository<PackageDetail, Long> {

	public List<PackageDetail> findByName(String name);

	public PackageDetail findByNameAndCategory(String name, String category);

}