package com.example.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.payment.entity.Payment;
import com.example.payment.service.PaymentServie;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentServie paymentService;
	
	@GetMapping("/getAllPayments")
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayments();
		
	}
	
	@PostMapping("/addPaymet")
	public Payment addPayment(@RequestParam Long BillId) {
	   return paymentService.addPayment(BillId);
	}
	
	

}
