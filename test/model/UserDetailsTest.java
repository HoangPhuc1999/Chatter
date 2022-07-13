/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author khuat
 */
public class UserDetailsTest {
    
    public UserDetailsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAccount() {
        System.out.println("getAccount");
        UserDetails instance = new UserDetails();
        UserAccount expResult = null;
        UserAccount result = instance.getAccount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetAccount() {
        System.out.println("setAccount");
        UserAccount account = null;
        UserDetails instance = new UserDetails();
        instance.setAccount(account);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrders() {
        System.out.println("getOrders");
        UserDetails instance = new UserDetails();
        ArrayList<Order> expResult = null;
        ArrayList<Order> result = instance.getOrders();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrders() {
        System.out.println("setOrders");
        ArrayList<Order> orders = null;
        UserDetails instance = new UserDetails();
        instance.setOrders(orders);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        UserDetails instance = new UserDetails();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
