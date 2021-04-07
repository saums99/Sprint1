package com.cg.sbs.controller;

	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;



	import com.cg.sbs.exceptions.CustomerNotFoundException;
	import com.cg.sbs.exceptions.InvalidCustomerException;

	@RestControllerAdvice
	public class CentralizeExceptionHandler {

		/**
		 * scenario : Catching Exception when  customer is invalid
		 */

		@ExceptionHandler(InvalidCustomerException.class)
		public String invalidCustomerException(InvalidCustomerException e) {
			return e.getMessage();
		}


		/**
		 * scenario : Catching Exception, when customer is not present in database
		 */
		@ExceptionHandler(CustomerNotFoundException.class)
		public String customerNotFoundException(CustomerNotFoundException e) {
			return e.getMessage();
		}

	}


