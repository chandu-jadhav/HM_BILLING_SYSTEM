package com.example.bill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bill.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
	

}
