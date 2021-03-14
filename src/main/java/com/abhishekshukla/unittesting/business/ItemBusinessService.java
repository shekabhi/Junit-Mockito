package com.abhishekshukla.unittesting.business;

import com.abhishekshukla.unittesting.Repo.ItemRepository;
import com.abhishekshukla.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemBusinessService {

    private final ItemRepository itemRepository ;

    public ItemBusinessService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item retriveHardCodedItem() {
        return new Item(1,"ball",10,1000) ;
    }

    public List<Item> retrieveAllItems(){
        List<Item> items = itemRepository.findAll();
        for(Item item: items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items ;
    }
}
