package com.cts.calculatenetworth.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.calculatenetworth.vo.StockDetailsVO;

@FeignClient(url = "http://ec2-18-237-194-15.us-west-2.compute.amazonaws.com:8082", name = "DAILYSHAREPRICE-SERVICE")
public interface DailySharePriceClient {
	
	@GetMapping(value="/DailySharePrice/{stockName}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockDetailsVO getStockDetail(@RequestHeader("Authorization") String authorization,@PathVariable String stockName);

}
