package com.example.dto;

import java.util.Map;

public class OrderList {
	
	private Map<String, Integer> itemsAndid;
    private Long tableId;

    public Map<String, Integer> getItemsAndid() {
        return itemsAndid;
    }

    public void setItemsAndid(Map<String, Integer> itemsAndid) {
        this.itemsAndid = itemsAndid;
    }

    public Long getTableId() {
        return tableId;
    }

    public void setTableId(Long tableId) {
        this.tableId = tableId;
    }

}
