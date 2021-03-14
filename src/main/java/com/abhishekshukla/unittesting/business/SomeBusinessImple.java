package com.abhishekshukla.unittesting.business;

import org.springframework.stereotype.Component;

@Component
public class SomeBusinessImple {

    private SomeDataService someDataService ;

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(){
        int sum = 0 ;
        int[] data = someDataService.retrieveAllData() ;
        for(int x : data)sum+= x ;

        return  sum ;
    }

}
