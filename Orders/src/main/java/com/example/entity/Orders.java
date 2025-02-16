package com.example.entity;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "order_seq_gen")
    @SequenceGenerator(name = "order_seq_gen" , sequenceName = "order_id_seq" , allocationSize = 1)
    long orderId;

    @Column(name = "table_id" , nullable = false)
    long tableId;

    @Column(name = "menu_item_id" , nullable = false)
    long menuId;

    @Column(name = "quantity" , nullable = false)
    Integer quantity;

    @Column(name = "price" , nullable = false , precision = 10 , scale = 2)
    BigDecimal price;

    @Column(name = "order_timestamp" , columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    LocalDateTime orderTimeStamp;

    @Column(name = "session_id")
    Long sessionId;
    
    @Column(name = "orderdetails")
    String orderDetails;
    
    @Column(name = "billId")
    Long BillId;


    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getOrderTimeStamp() {
        return orderTimeStamp;
    }

    public void setOrderTimeStamp(LocalDateTime orderTimeStamp) {
        this.orderTimeStamp = orderTimeStamp;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

	public String getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(String orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Long getBillId() {
		return BillId;
	}

	public void setBillId(Long billId) {
		BillId = billId;
	}
	
	
    
}
