package com.RestaurantTable.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;

public class Menu {
	
	private long id;

    private String name ;

    private String  category;

    private String portionSize;

    private BigDecimal price;

    private String description;

    private Boolean isavailable;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPortionSize() {
		return portionSize;
	}

	public void setPortionSize(String portionSize) {
		this.portionSize = portionSize;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsavailable() {
		return isavailable;
	}

	public void setIsavailable(Boolean isavailable) {
		this.isavailable = isavailable;
	}
    
    

}
