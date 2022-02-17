package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

/**
 * @author linkun
 * @date 2022/2/9 10:57
 */
public class MockTest {
    public static void beforeAll() {

    }

    public static void afterAll() {

    }

    @Test
    public void test() {
        List mockList = mock(List.class);
        mockList.add("one");
        mockList.add("two");
        mockList.clear();

        System.out.println("==============");

        verify(mockList).add("two");
        verify(mockList).clear();
    }

    @Test
    public void test2() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("one");
        when(mockList.get(0)).thenReturn("two");
        when(mockList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockList.get(0));
        System.out.println(mockList.get(0));
//        System.out.println(mockList.get(1));
        System.out.println(mockList.get(999));

        verify(mockList).get(0);

        given(mockList.get(0)).willReturn("xxxx");
        
    }

}
