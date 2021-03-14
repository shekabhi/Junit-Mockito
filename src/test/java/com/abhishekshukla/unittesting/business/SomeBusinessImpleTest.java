package com.abhishekshukla.unittesting.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImpleTest {

    @InjectMocks
    SomeBusinessImple someBusinessImple ;

    @Mock
    SomeDataService dataServiceMock ;


    @Test
    void calculateSumUsingDataServices() {
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {1,2,3}) ;
        int actualResult = someBusinessImple.calculateSum() ;
        int expectedResult = 6 ;
        assertEquals(actualResult , expectedResult);
    }

    @Test
    void calculateSumEmptyUsingDataServices(){

        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {}) ;
        int actualResult = someBusinessImple.calculateSum();
        int expectedResult = 0 ;
        assertEquals(actualResult , expectedResult);
    }
}