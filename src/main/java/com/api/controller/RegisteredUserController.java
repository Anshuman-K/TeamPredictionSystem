 package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.api.DTO.RegisteredUserDTO;
import com.api.service.RegisteredUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/register")
public class RegisteredUserController {
	
	@Autowired
	RegisteredUserService registeredUserService;
	
	@PostMapping("/create")
	public String createUser(@RequestBody RegisteredUserDTO request) {
		return registeredUserService.createUser(request);
	}
	
	@GetMapping("/get/{userName}")
	public ResponseEntity<RegisteredUserDTO> getUser(@PathVariable("userName") String userName) {
		RegisteredUserDTO data = registeredUserService.getUser(userName);
		return new ResponseEntity<RegisteredUserDTO>(data, HttpStatus.OK);
	}

	@GetMapping("/confirm")
	public String confirm(@RequestParam("token") String token) {
		return registeredUserService.confirmToken(token);
	}
}
