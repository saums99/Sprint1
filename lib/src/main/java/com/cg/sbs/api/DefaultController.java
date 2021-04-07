package com.cg.sbs.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class DefaultController {
	
	@RestController
	@RequestMapping(path="/")
	public class DefaultRestController {
		
		@GetMapping
		public ResponseEntity<String> defaultAction() {
			return new ResponseEntity<>("Stationery Booking System API v1", HttpStatus.OK);
		}
	}

}
