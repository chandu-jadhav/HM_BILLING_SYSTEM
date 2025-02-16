package com.example.bill.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bill.entity.Orders;

@FeignClient(name = "Orders")
public interface OrderFeign {
	
	@GetMapping("/orders/getOrderById")
	public Orders getOrderById(@RequestParam Long OrderId);

}
