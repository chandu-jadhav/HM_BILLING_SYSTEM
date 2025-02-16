package com.RestaurantTable.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.RestaurantTable.Repository.RestaurantTableRepository;
import com.RestaurantTable.dto.RestaurantTabledto;
import com.RestaurantTable.entity.RestaurantTable;

@Service
public class RestaurantTableService {
	
	@Autowired
	private RestaurantTableRepository restaurantTableRepository;

	public List<RestaurantTable> getAllTables() {
		// TODO Auto-generated method stub
		return restaurantTableRepository.findAll();
	}

	public List<RestaurantTable> getAllAvailableTables(String status, Sort sort) {
		// TODO Auto-generated method stub
		return restaurantTableRepository.findByStatus(status, sort);
	}

	
	 public RestaurantTable saveTable(RestaurantTabledto table) {
		     RestaurantTable Table= new RestaurantTable();
		     //Table = table;
		     Table.setTableId(table.getTableId());
		     Table.setCurrentBillId(table.getCurrentBillId());
		     Table.setStatus(table.getStatus());
		 
	        return restaurantTableRepository.save(Table);
	    }

	public Optional<RestaurantTable> getTable(long tableId) {
		// TODO Auto-generated method stub
		return restaurantTableRepository.findById(tableId);
	}
	
	

}
