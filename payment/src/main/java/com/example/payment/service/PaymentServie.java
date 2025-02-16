package com.example.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.payment.configuration.BillFeign;
import com.example.payment.entity.Bill;
import com.example.payment.entity.Payment;
import com.example.payment.repository.PaymentRepository;

@Service
public class PaymentServie {
	
	@Autowired
	private PaymentRepository paymentRepository;

	
	@Autowired
	private BillFeign billFeign;
	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}
	
	public Payment addPayment( Long BillId) {
		Bill bill =  billFeign.getbill(BillId);
		
		Payment payment =  new Payment();
		
		payment.setAmount(bill.getTotalAmount());
		payment.setPayment_method(bill.getPaymentMethod());
		payment.setPayment_time(bill.getPaymentTime());
		payment.setBill_id(bill.getId());
		
		return paymentRepository.save(payment);
		
	
		
		
		
	}

}
