package com.cts.calculatenetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.calculatenetworth.vo.MutualFundVO;



@FeignClient(url = "http://ec2-34-213-29-53.us-west-2.compute.amazonaws.com:8083", name = "MUTUALFUNDNAV-SERVICE")
public interface DailyMutualFundNAVClient {

	@GetMapping(value = "/DailyMutualFundNAV/{mutualFundName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public MutualFundVO getMutualFundDetails(@RequestHeader("Authorization") String authorization,
			@PathVariable String mutualFundName);
}
