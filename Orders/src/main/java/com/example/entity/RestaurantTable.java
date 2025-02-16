package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class RestaurantTable {

    
    private Long id;

    private String status;  // Status like Available, Occupied

    private Long currentBillId;  // Nullable reference to current bill

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Long getCurrentBillId() {
        return currentBillId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCurrentBillId(Long currentBillId) {
        this.currentBillId = currentBillId;
    }
}