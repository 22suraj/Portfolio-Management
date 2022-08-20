package com.cts.dailymutualfundnav.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(url = "http://ec2-54-189-204-241.us-west-2.compute.amazonaws.com:8081", name = "AUTHORIZATION-SERVICE")
public interface AuthorizationClient {
	
	@GetMapping("/getuname")
	public String getUname(@RequestHeader("Authorization") String authorization);

}
