package com.example.bill.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;

public class Orders {
	
	    long orderId;
	 
	    long tableId;
	 
	    long menuId;

	    Integer quantity;
	    
	    BigDecimal price;

	    LocalDateTime orderTimeStamp;

	    Long sessionId;
	    
	    String orderDetails;

		public Long BillId;

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
