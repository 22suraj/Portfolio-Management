package com.cts.authorization.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JwtRequestTest {

	
	@Test
	void testGetterSetter() {
		JwtRequest jwtRequest = new JwtRequest();
		
		jwtRequest.setUsername("tharun");
		jwtRequest.setPassword("6287");
		
		assertEquals("tharun",jwtRequest.getUsername());
		assertEquals("6287",jwtRequest.getPassword());
	
		assertEquals(jwtRequest.toString(),jwtRequest.toString());

		
	}
	

}
