package com.example.configuration;
//
//import java.awt.Menu;
import com.example.entity.Menu;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="Menu")
public interface MenuFeign {
	
	 @GetMapping("/menu/getMenuById") // Endpoint exposed by Menu service
	   Menu getMenuItem(@RequestParam("itemId") Long itemId);

}
