package com.spring.springTraining.Controller;


import com.spring.springTraining.Entity.Menu;
import com.spring.springTraining.Service.Interfaces.MenuService;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

public class MenuTest {
    @InjectMocks
    MenuService menuService;

    @Mock
    Menu menu;

    @BeforeAll
    public static void before(){
        System.out.println("before all");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println("before each");
    }

    @AfterAll
    public static void after(){
        System.out.println("after all");
    }

    @AfterEach
    public void aftereach(){
        System.out.println("after each");
    }

    //@Test(timeout == 1)
    public void myTestLists(){
        System.out.println("inside my lists test");
        List<String> list = new ArrayList<>(Arrays.asList("1", "2"));
        List<String> list2 = new ArrayList<>(Arrays.asList("1", "2"));

        assertNotSame(list, list2);
        assertSame(list, list);

    }

    @Test
    public void myTestAssert(){
        System.out.println("inside my assert test");
        assertEquals("text", "text");
        assertNull(null);
        assertNotNull("text");
        assertTrue(1==1);
        assertFalse(1!=1);
    }

    //@Test(exception == ArithmeticException.class)
    public void myTestException(){
        int i = 1/0;
    }

    @Test
    public void getById(){
        when(menuService.getMenuById(1)).thenReturn(menu);
        assertNotNull(menuService.getMenuById(1));
    }

    @Test
    public void assertException(){
        doThrow(new ArithmeticException("Something went wrong"))
                .when(menuService.getMenuById(1));

        assertNotNull(menuService.getMenuById(1));
    }
}
