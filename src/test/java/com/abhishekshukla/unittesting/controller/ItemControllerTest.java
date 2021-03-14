package com.abhishekshukla.unittesting.controller;

import com.abhishekshukla.unittesting.business.ItemBusinessService;
import com.abhishekshukla.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc ;

    @MockBean
    private ItemBusinessService businessService ;

    @Test
    void dummyItem() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{" +
                        "\"id\": 1," +
                        "\"name\":\"ball\"," +
                        "\"price\": 10," +
                        "\"quantity\": 1000" +
                        "}"))
                .andReturn() ;

    }
    @Test
    void itemFromBusinessService_basic() throws Exception {

        when(businessService.retriveHardCodedItem()).thenReturn(
                new Item(2 , "Item2" , 10 ,10)
        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2 ,name:Item2, price:10 , quantity:10}"))
                .andReturn() ;

    }

    @Test
    void retrieveAllItems_basic() throws Exception {

        when(businessService.retrieveAllItems()).thenReturn(
                Arrays.asList(new Item(2 , "Item2" , 10 ,10),
                        new Item(3 , "Item3" , 20 ,20) )

        );

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2 ,name:Item2, price:10 , quantity:10},{id:3 ,name:Item3, price:20 , quantity:20}]"))
                .andReturn() ;

    }
}