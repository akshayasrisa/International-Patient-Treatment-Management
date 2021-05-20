package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IpTreatmentPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpTreatmentPortalApplication.class, args);
	}

}
