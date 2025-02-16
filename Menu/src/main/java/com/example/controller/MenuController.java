package com.example.controller;


import com.example.entity.Menu;
import com.example.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.entity.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/getAllAvailableMenu")
    public List<Menu> getAllAvailableMenu(){

        return menuRepository.findAll();

    }

    @PostMapping("/addMenuItem")
    public String addMenuItem(@RequestBody Menu menu){
        //checks if item is presest in menu  or not with is portion and name as one name  can be present with multiple portions
        Optional<Menu> m  = menuRepository.findByNameAndPortionSize(menu.getName() , menu.getPortionSize());
        if(m !=null){
            return "Menu item present already";
        }
        menuRepository.save(menu);
        return  "Menu item has added successfull";
    }
    
    @GetMapping("/getMenuById")
    public Optional<Menu> getMenuById(@RequestParam Long itemId) {
    	return menuRepository.findById(itemId);
    }



}
