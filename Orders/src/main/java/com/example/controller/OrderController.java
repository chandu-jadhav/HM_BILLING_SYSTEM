package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.OrderList;
import com.example.entity.Orders;
import com.example.repositpry.OrderRepository;
import com.example.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderRepository orderRepository;
    
    @Autowired
    OrderService orderService;

    @GetMapping("/getorders")
    public List<Orders> getorders(){
        return  orderRepository.findAll();

    }
    
//    @PostMapping("/placeOrder")
//    public Orders placeOrder(@RequestParam Long MenuItemId) {
//    	return orderService.createOrders(MenuItemId);
//    	 
//    }
    
//    @PostMapping("/placeOrder")
//    public Orders placeOrder(@RequestBody Map<String, Integer> menuItemList , @RequestParam Long tableId) {
//    	//return orderService.cereteOrders(MenuItemId);
//    	// Convert String keys to Long
//        Map<Long, Integer> convertedMenuItemList = new HashMap<>();
//        for (Map.Entry<String, Integer> entry : menuItemList.entrySet()) {
//            convertedMenuItemList.put(Long.parseLong(entry.getKey()), entry.getValue());
//        }
//    	
//    	return orderService.createOrders(convertedMenuItemList , tableId);
//    	 
//    }
    
    @PostMapping("/placeOrder")
    public Orders placeOrder(@RequestBody OrderList request) {
        // Convert String keys to Long
        Map<Long, Integer> convertedMenuItemList = new HashMap<>();
        for (Map.Entry<String, Integer> entry : request.getItemsAndid().entrySet()) {
            convertedMenuItemList.put(Long.parseLong(entry.getKey()), entry.getValue());
        }

        return orderService.createOrders(convertedMenuItemList, request.getTableId());
    }
    
    @GetMapping("/getOrderById")
    public Optional<Orders> getOrderById(@RequestParam Long  OrderId) {
        return orderService.getOrderById(OrderId);
    }
    
    
    
    
    
}
