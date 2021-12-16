package com.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.DTO.JwtResponse;
import com.api.DTO.RegisteredUserDTO;
import com.api.service.CustomUserDetailService;
import com.api.utility.JwtUtility;


@CrossOrigin
@RestController
@RequestMapping("/api/v1/login")
public class JwtController {
	
	@Autowired
	private JwtUtility jwtUtility;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<JwtResponse> authenticate(@RequestBody RegisteredUserDTO data) throws Exception {
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(data.getUserName(),data.getPassword()));
		}catch(UsernameNotFoundException e){
			e.printStackTrace();
			throw new Exception("Bad Credentials", e);
			
		}catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials", e);
		}
		
		
		final UserDetails userDetail = this.customUserDetailService.loadUserByUsername(data.getUserName());
		final String token = this.jwtUtility.generateToken(userDetail);
		
		return new ResponseEntity<JwtResponse>(new JwtResponse(token), HttpStatus.CREATED);
	}
		
}
