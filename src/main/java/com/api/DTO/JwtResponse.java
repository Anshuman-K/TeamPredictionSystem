package com.api.DTO;

import org.springframework.stereotype.Component;

@Component
public class JwtResponse {
	
	private String token;
	
	public JwtResponse() {}

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}
		
}
