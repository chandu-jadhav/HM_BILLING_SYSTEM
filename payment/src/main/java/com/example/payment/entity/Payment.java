package com.example.payment.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Fallback;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_seq_gen")
    @SequenceGenerator(name = "payment_seq_gen", sequenceName = "payment_id_seq", allocationSize = 1)
	@Column(name = "id")
	private Long id;
	
	@Column(name =  "amount" ,  nullable = false)
	private BigDecimal amount;
	
	@Column(name = "payment_method")
	private String payment_method;
	
	@Column(name = "payment_time" , nullable = false)
	private LocalDateTime payment_time;
	
	@Column(name = "bill_id")
	private Long  bill_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public LocalDateTime getPayment_time() {
		return payment_time;
	}

	public void setPayment_time(LocalDateTime payment_time) {
		this.payment_time = payment_time;
	}

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}
	
	
	
	

}
