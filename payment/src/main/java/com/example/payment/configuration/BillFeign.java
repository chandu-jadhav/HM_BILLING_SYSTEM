package com.example.payment.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.payment.entity.Bill;

@FeignClient(name = "Bill")
public interface BillFeign {
	
	
	@GetMapping("/bill/getBill")
	public Bill getbill(@RequestParam Long BillId);

}
