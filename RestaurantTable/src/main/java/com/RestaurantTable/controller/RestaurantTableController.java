package com.RestaurantTable.controller;


import com.RestaurantTable.Repository.RestaurantTableRepository;
import com.RestaurantTable.dto.RestaurantTabledto;
import com.RestaurantTable.entity.RestaurantTable;
import com.RestaurantTable.service.RestaurantTableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/restauranttable")
public class RestaurantTableController {

    @Autowired
     private RestaurantTableRepository restaurntTableRepository;
    
    @Autowired
     private RestaurantTableService restaurantTableService;


    @GetMapping("/getAllTables")
    public List<RestaurantTable> getAllTables(){
    	
    	return restaurantTableService.getAllTables();
    }
    
    @GetMapping("/getAllAvailableTables")
    public  List<RestaurantTable> getAllAvailableTables(){
        //sort object to get response in sorted format by id
        Sort sort = Sort.by(Sort.Direction.ASC,"Id");
        return restaurantTableService.getAllAvailableTables("Available",sort);

    }
    @GetMapping("/getAllOccupiedTables")
    public  List<RestaurantTable> getAllOccupiedTables(){
        Sort sort = Sort.by(Sort.Direction.ASC,"Id");
        return  restaurntTableRepository.findByStatus("Occupied",sort);
        

    }
    //changing status of table from Available to occupied
    @PostMapping("/setStatus")
    public RestaurantTable setOccupiedStatus(@RequestParam Long tableId , @RequestParam Long billId) throws Exception{
        //get table for provided table id
        RestaurantTable table = restaurntTableRepository.findById(tableId).orElse(null);

        if(table != null && table.getStatus().equalsIgnoreCase("Available")){
            table.setStatus("Occupied");
            table.setCurrentBillId(billId);
            return restaurntTableRepository.save(table);
        }
        return null ;

    }
    //now changing status from occupied to available
    @PostMapping("/setAvailable")
    public RestaurantTable setAvailableStatus(@RequestParam Long tableId) throws Exception{
        RestaurantTable table =  restaurntTableRepository.findById(tableId).orElse(null);
        if(table!=null && table.getStatus().equalsIgnoreCase("occupied")){
            table.setStatus("Available");
            table.setCurrentBillId(null);
            return  restaurntTableRepository.save(table);
        }
        return null;
    }
    
    //taking table object  from frontend and storing it to db
//    @PostMapping("/saveTableDetails")
//    public ResponseEntity<RestaurantTable> saveTable(@RequestBody RestaurantTable table) {
//        RestaurantTable savedTable = restaurantTableService.saveTable(table);
//        return ResponseEntity.ok(savedTable);
//        
//        
//    }
    
    @PostMapping("/saveTableDetails")
    public ResponseEntity<RestaurantTable> saveTable(@RequestBody RestaurantTabledto table) {
        RestaurantTable savedTable = restaurantTableService.saveTable(table);
        return ResponseEntity.ok(savedTable);
        
        
    }
    
    
    
    @GetMapping("/tableById")
    public Optional<RestaurantTable> tableByID(@RequestParam long tableId) {
        return restaurantTableService.getTable(tableId);
    }
    

}
