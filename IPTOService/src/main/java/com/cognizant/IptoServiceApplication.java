package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IptoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IptoServiceApplication.class, args);
	}
	
	
	

}
