package com.abhishekshukla.unittesting.controller;

import com.abhishekshukla.unittesting.business.ItemBusinessService;
import com.abhishekshukla.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService ;

    @GetMapping("/dummy-item")
    public Item dummyItem(){
        return new Item(1,"ball",10,1000) ;
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService(){
        return itemBusinessService.retriveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems(){
        return itemBusinessService.retrieveAllItems() ;
    }


}
