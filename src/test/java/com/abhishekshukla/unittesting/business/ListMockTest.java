package com.abhishekshukla.unittesting.business;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListMockTest {

    List mock = mock(List.class) ;

    @Test
    void size_basic(){
        when(mock.size()).thenReturn(5) ;
        assertEquals(5,mock.size()) ;
    }

    @Test
    void returnDifferentValues(){
        when(mock.size()).thenReturn(5).thenReturn(10) ;
        assertEquals(5,mock.size());
        assertEquals(10 , mock.size());
    }

    @Test
    void returnWithParameters(){
        when(mock.get(0)).thenReturn("ok") ;
        assertEquals("ok" , mock.get(0));
        assertEquals(null , mock.get(1));
    }

    @Test
    void returnWithGenericParameters(){
        when(mock.get(anyInt())).thenReturn("ok") ;
        assertEquals("ok" , mock.get(0));
        assertEquals("ok" , mock.get(1));
    }
}
