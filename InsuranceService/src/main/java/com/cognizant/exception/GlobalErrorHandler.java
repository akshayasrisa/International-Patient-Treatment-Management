package com.cognizant.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Pod3
 * @version 1.8
 * @apiNote This class handles all the exceptions. Whenever an exception occurs
 *          anywhere then first it will be checked whether there is
 *          {@link GlobalErrorHandler} declared or not. This has an annotation
 *          RestControllerAdvice so it works for all controllers and classes.
 * 
 * @see ResponseEntityExceptionHandler
 * 
 */
@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {
	/**
	 * This method will handle all type of exceptions unless no specific method is
	 * written to handle that exception
	 * 
	 * @param Exception object
	 * @return Exception format in the form of CutomErrorResponse object It handles
	 *         all types of exceptions
	 * 
	 * @see CustomErrorResponse
	 * @see Exception
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse> handleAllErrors(Exception ex) {
		log.info("Start");
		CustomErrorResponse response = new CustomErrorResponse();
		response.setTimestamp(LocalDateTime.now());
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST);
		response.setReason("BAD_REQUEST");
		log.info("End");
		return new ResponseEntity<CustomErrorResponse>(response, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method will handles {@link MethodArgumentTypeMismatchException}
	 * exception, whenever there is a mismatch in the input provided then from this
	 * method it will get handled.
	 * 
	 * @param MethodArgumentTypeMismatchException object
	 * @return {@link CustomErrorResponse} object Exception format in the form of
	 *         CutomErrorResponse object
	 * 
	 * @see CustomErrorResponse
	 * @see MethodArgumentTypeMismatchException
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<CustomErrorResponse> handleMethodArgTypeMismatchException(
			MethodArgumentTypeMismatchException e) {
		log.info("Start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.BAD_REQUEST);
		customErrorResponse.setMessage("Please enter the date in MM-dd-yyyy format");
		customErrorResponse.setReason("You might have provided wrong date format");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		log.info("End");
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse, HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method will handle {@link DateNotFoundException} exception, whenever
	 * there is a null date in the input provided then from this method it will get
	 * handled.
	 * 
	 * @param DateNotFoundException object
	 * @return {@link CustomErrorResponse} object Exception format in the form of
	 *         CutomErrorResponse object
	 * 
	 * @see CustomErrorResponse
	 * @see DateNotFoundException
	 */
	@ExceptionHandler(DateNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleDateNotFoundException(DateNotFoundException e) {
		log.info("Start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.NOT_FOUND);
		customErrorResponse.setMessage("Please enter the date in MM-dd-yyyy format");
		customErrorResponse.setReason("You might have provided wrong date format");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		log.info("End");
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse, HttpStatus.NOT_FOUND);
	}

	/**
	 * This method will handles {@link TokenValidationFailedException} exception,
	 * whenever there is an invalid token or expired provided then from this method
	 * it will get handled.
	 * 
	 * @param TokenValidationFailedException object
	 * @return {@link CustomErrorResponse} object Exception format in the form of
	 *         CutomErrorResponse object
	 * 
	 * @see CustomErrorResponse
	 * @see TokenValidationFailedException
	 */
	@ExceptionHandler(TokenValidationFailedException.class)
	public ResponseEntity<CustomErrorResponse> handleTokenValidationFailedException(TokenValidationFailedException e) {
		log.info("Start");
		CustomErrorResponse customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setStatus(HttpStatus.FORBIDDEN);
		customErrorResponse.setMessage("Please enter valid token");
		customErrorResponse.setReason("Your token might have been expired or you have entered wrong token");
		customErrorResponse.setTimestamp(LocalDateTime.now());
		log.info("End");
		return new ResponseEntity<CustomErrorResponse>(customErrorResponse, HttpStatus.FORBIDDEN);
	}

}
