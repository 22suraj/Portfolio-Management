package com.cts.authorization.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.cts.authorization.exception.UserNotFoundException;
import com.cts.authorization.util.JwtRequest;
import com.cts.authorization.util.JwtResponse;

@SpringBootTest
public class AuthControllerTest {

	
	@Autowired
	private AuthController authController;
	

	
	@Test
	void createAuthenticationTokenTest() {
		this.generateToken();	
	}
	
	
	
	@Test
	void getUnameTest() {
		JwtResponse res = this.generateToken();	
		String uname = this.authController.getUname("Bearer "+res.getJwttoken());
		
		assertEquals("tharun", uname);
	}
	
	
	
	
	@Test
	void getUserIdTest() {
		 JwtResponse res = this.generateToken();	
		 int userId = this.authController.getUserId("Bearer "+res.getJwttoken());
		 assertEquals(102, userId);
	}
	
	
	@Test
	void checkTest() {
		JwtResponse res = this.generateToken();	
		String check = this.authController.check(res.getJwttoken());
	    assertEquals("Healthy"+res.getJwttoken(), check);
	}
	
	
	
	
	
	// Generating token
	private JwtResponse generateToken() {
		
		JwtRequest jwtRequest = new JwtRequest();
		jwtRequest.setUsername("tharun");
		jwtRequest.setPassword("6287");

		JwtResponse res = null;
		try {
			ResponseEntity<JwtResponse> createAuthenticationToken = this.authController
					.createAuthenticationToken(jwtRequest);
			 res =  createAuthenticationToken.getBody();
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		return res;
	}
}
