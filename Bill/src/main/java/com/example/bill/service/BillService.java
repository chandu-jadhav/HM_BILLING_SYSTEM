package com.example.bill.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.bill.configuration.OrderFeign;
import com.example.bill.dto.tableIdAndOrderId;
import com.example.bill.entity.Bill;
import com.example.bill.entity.Orders;
import com.example.bill.repository.BillRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BigIntegerDeserializer;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private OrderFeign orderFeign;

	public List<Bill> getAllBills() {
		// TODO Auto-generated method stub
		return billRepository.findAll();
	}

//	public Bill createBill(tableIdAndOrderId tableIdAndOrderId) {
//
//		Orders order = orderFeign.getOrderById(tableIdAndOrderId);
//
//		Bill bill = new Bill();
//
//		BigDecimal subtotal = order.getPrice();
//		BigDecimal discount = (subtotal.compareTo(BigDecimal.valueOf(500)) > 0)
//				? (subtotal.multiply(BigDecimal.valueOf(0.10)))
//				: (BigDecimal.ZERO);
//		BigDecimal tax = subtotal.multiply(BigDecimal.valueOf(0.05));
//
//		bill.setSubtotal(subtotal);
//		bill.setDiscount(discount);
//		bill.setTax(tax);
//		bill.setTotalAmount(subtotal.subtract(discount).add(tax));
//		bill.setIsPaid(true);
//		bill.setPaymentMethod("card");
//		bill.setPaymentTime(LocalDateTime.now());
//		bill.setTableId(order.getTableId());
//
//		return billRepository.save(bill);
//
//	}

	public Optional<Bill> getBill(Long billId) {
		// TODO Auto-generated method stub
		return billRepository.findById(billId);
	}

	public Bill createBill(long tableId, long orderId) {
		// TODO Auto-generated method stub
		Orders order = orderFeign.getOrderById(orderId);

		Bill bill = new Bill();

		BigDecimal subtotal = order.getPrice();
		BigDecimal discount = (subtotal.compareTo(BigDecimal.valueOf(500)) > 0)
				? (subtotal.multiply(BigDecimal.valueOf(0.10)))
				: (BigDecimal.ZERO);
		BigDecimal tax = subtotal.multiply(BigDecimal.valueOf(0.05));
        bill.setId(order.getBillId());
		bill.setSubtotal(subtotal);
		bill.setDiscount(discount);
		bill.setTax(tax);
		bill.setTotalAmount(subtotal.subtract(discount).add(tax));
		bill.setIsPaid(true);
		bill.setPaymentMethod("card");
		bill.setPaymentTime(LocalDateTime.now());
		bill.setTableId(order.getTableId());

		return billRepository.save(bill);
	}

}
