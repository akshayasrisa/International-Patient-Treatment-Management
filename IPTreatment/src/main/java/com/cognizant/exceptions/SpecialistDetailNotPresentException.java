package com.cognizant.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "SpecialistDetail Entry not found")
public class SpecialistDetailNotPresentException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SpecialistDetailNotPresentException() {
		super("SpecialistDetail Feign Exchange Service Error");
		log.debug("exception throwed");
	}

}
