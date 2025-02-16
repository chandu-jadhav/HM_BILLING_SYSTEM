package com.example.bill.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bill.entity.Bill;
import com.example.bill.service.BillService;
import com.example.bill.dto.tableIdAndOrderId;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private BillService billService;
	
	@GetMapping("/getAllBills")
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
//	@PostMapping("/postBill")
//	public Bill postBill(@RequestParam Long orderId) {
//		return billService.createBill(orderId);
//		
//	}
	
	@PostMapping("/saveBill")
	public Bill saveBill(@RequestBody tableIdAndOrderId tableIdAndOrderId) {
		 long tableId = tableIdAndOrderId.getTableId();
		 long orderId  = tableIdAndOrderId.getOrderId();
		return billService.createBill(tableId,orderId);
	}
		
	
	
	
	
	@GetMapping("/getBill")
	public Optional<Bill> getBill(@RequestParam Long BillId) {
		return billService.getBill(BillId);
	}
		
	
	
	
	

}
