package com.RestaurantTable.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Restauranttable")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantTable {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)  // For BIGSERIAL equivalent
    @GeneratedValue(strategy = GenerationType.IDENTITY , generator = "table_seq_gen")
    @SequenceGenerator(name = "table_seq_gen" , sequenceName = "table_id_seq" , allocationSize = 1)
    private Long id;
    
    @Column(name = "tableId" , length = 5)
    private Long tableId;

    @Column(name = "status", length = 20)
    private String status;  // Status like Available, Occupied

    @Column(name = "current_bill_id", nullable = true)
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
    
    public void setTableId(long tableId) {
    	this.tableId = tableId;
    }
    
    public Long getTableId(){
    	return tableId;
    	
    }
    
    
    
}