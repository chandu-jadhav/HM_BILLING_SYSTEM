package com.RestaurantTable.dto;

public class RestaurantTabledto {
	
	long tableId;
	long currentBillId;
	String status;
	public long getTableId() {
		return tableId;
	}
	public void setTableId(long tableId) {
		this.tableId = tableId;
	}
	public long getCurrentBillId() {
		return currentBillId;
	}
	public void setCurrentBillId(long currentBillId) {
		this.currentBillId = currentBillId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
