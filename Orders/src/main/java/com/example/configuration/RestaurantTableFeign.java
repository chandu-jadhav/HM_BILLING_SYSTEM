package com.example.configuration;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.RestaurantTable;

@FeignClient(name = "RestaurantTable")
public interface RestaurantTableFeign {
	
	
	@GetMapping("/restauranttable/tableById")
	RestaurantTable getTableById(@RequestParam long tableId);

}
