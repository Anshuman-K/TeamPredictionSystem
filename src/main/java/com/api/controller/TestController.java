package com.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/test")
public class TestController {
	
	@GetMapping("/match")
	public ResponseEntity<String> getUser() {
		return new ResponseEntity<String>("Tested Successfully", HttpStatus.OK);
	}
}
