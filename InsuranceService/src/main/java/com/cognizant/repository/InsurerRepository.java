package com.cognizant.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.model.InsurerDetail;




public interface InsurerRepository extends JpaRepository<InsurerDetail, Integer> {


	
	public InsurerDetail findByInsurerPackageName(String insurerPackageName);


}