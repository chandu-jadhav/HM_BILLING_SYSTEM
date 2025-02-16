package com.example.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.configuration.MenuFeign;
import com.example.configuration.RestaurantTableFeign;
import com.example.entity.Menu;
import com.example.entity.Orders;
import com.example.entity.RestaurantTable;
import com.example.repositpry.OrderRepository;
import com.netflix.discovery.converters.Auto;

import jakarta.persistence.criteria.CriteriaBuilder.In;

@Service
public class OrderService {
	@Autowired
	private MenuFeign menuFeign;
	
	@Autowired
	private RestaurantTableFeign restaurantTableFeign;
	
	@Autowired 
	private OrderRepository orderRepository;
	
//	private static final String ORDER_CREATED_TOPIC = "order-created";
//	
//	@Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
	
	

	
	public Orders createOrders(Map<Long, Integer> menuItemList, Long tableId) {
		// TODO Auto-generated method stub
		 BigDecimal Totalprice =BigDecimal.ZERO;
	     
		 StringBuilder orderDetails = new StringBuilder();
		 
		 RestaurantTable table =  restaurantTableFeign.getTableById(tableId);
		 
	     for(Map.Entry<Long,Integer> entry : menuItemList.entrySet()) {
	    	 Long menuItemId =entry.getKey();
	    	 Integer quantity = entry.getValue();
	    	 Menu menu =  menuFeign.getMenuItem(menuItemId);
	    	 if(menu.getIsavailable()) {
	    		 BigDecimal itemPrize =menu.getPrice().multiply(BigDecimal.valueOf(quantity));
	    		 //calculating total prize of order
	    		 Totalprice = Totalprice.add(itemPrize);
	    		 
	    		 //adding orders in form of String in 
	    		 orderDetails.append("(")
	    		 			 .append(menuItemId).append(",")
	    		             .append(menu.getName()).append(",")
	    		             .append(menu.getPortionSize()).append(",")
	    		             .append(quantity).append("), ");
	    		           
	    		 
	    	 }
	    	 
	    	 
	    	 
	     }
	     // Remove the trailing comma and space from the orderDetails string
	        if (orderDetails.length() > 0) {
	            orderDetails.setLength(orderDetails.length() - 2); // Remove the last ", "
	        }
	     Orders order =  new Orders();
	     order.setPrice(Totalprice);
		 order.setQuantity(1);
		 order.setTableId(tableId);
		 order.setOrderTimeStamp(LocalDateTime.now());
		 System.out.println(orderDetails);
		 order.setOrderDetails(orderDetails.toString());
		 order.setBillId(table.getCurrentBillId());
		 
		 return   orderRepository.save(order);
		 
		  // Publish an event to Kafka
//	        String orderMessage = String.format("TableId:%d, OrderId:%d", tableId, order.getOrderId());
//	        kafkaTemplate.send(ORDER_CREATED_TOPIC, orderMessage); // Sending order details to Kafka
		 
		 
		 
	}





	public Optional<Orders> getOrderById(Long orderId) {
		// TODO Auto-generated method stub
		return orderRepository.findById(orderId);
		
	}





	

		
	
	

}

	