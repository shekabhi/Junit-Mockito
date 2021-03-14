package com.abhishekshukla.unittesting.business;

import com.abhishekshukla.unittesting.Repo.ItemRepository;
import com.abhishekshukla.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService itemBusinessService;

    @Mock
    private ItemRepository itemRepository ;


    @Test
    public void calculateValuesUsingItemBusinessServices() {
        when(itemRepository.findAll()).thenReturn(
                Arrays.asList(new Item(2 , "Item2" , 10 ,10),
                        new Item(3 , "Item3" , 20 ,20) )
        );
        List<Item> items = itemBusinessService.retrieveAllItems();

        assertEquals(100 , items.get(0).getValue());
        assertEquals(400 , items.get(1).getValue());
    }

}