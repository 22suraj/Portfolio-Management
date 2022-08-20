package com.cts.authorization.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cts.authorization.model.User;
import com.cts.authorization.repository.UserRepository;

@SpringBootTest
class MyUserDetailsServiceTest {

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@MockBean
	UserRepository userRepository;

	@Test
	void contextLoads() {

		assertNotNull(myUserDetailsService);

	}

	@Test()
	void loadUserByUsernameTestSuccess() throws UsernameNotFoundException {
		
		User u = new User(1, "tharun", "628");
		Mockito.when(userRepository.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals("tharun", myUserDetailsService.loadUserByUsername("tharun").getUsername());
	}

	@Test
	void loadUserByUsernameTestFail() {
		User u = new User(1, "tharun", "628");
		Mockito.when(userRepository.findByUsername(u.getUsername())).thenReturn(u);
		assertEquals("tharun", myUserDetailsService.loadUserByUsername("tharun").getUsername());
	}

}
