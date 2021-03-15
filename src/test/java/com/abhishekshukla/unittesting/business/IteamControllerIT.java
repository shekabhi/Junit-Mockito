package com.abhishekshukla.unittesting.business;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IteamControllerIT {

    @Autowired
    private TestRestTemplate testRestTemplate ;

    @Test
    void contextLoad() throws JSONException {
        String response = this.testRestTemplate.getForObject("/all-items-from-database" , String.class) ;
        JSONAssert.assertEquals("[{id:10001,name:'Item1',price:10,quantity:20,value:200}," +
                "{id:10002,name:'Item2',price:20,quantity:40,value:800}," +
                "{id:10003,name:'Item3',price:30,quantity:10,value:300}]"
                , response , false);
    }
}
