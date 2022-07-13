/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

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
public class UserAddressTest {
    
    public UserAddressTest() {
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
    public void testGetUsers_id() {
        System.out.println("getUsers_id");
        UserAddress instance = new UserAddress();
        int expResult = 0;
        int result = instance.getUsers_id();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetUsers_id() {
        System.out.println("setUsers_id");
        int users_id = 0;
        UserAddress instance = new UserAddress();
        instance.setUsers_id(users_id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetHome_address() {
        System.out.println("getHome_address");
        UserAddress instance = new UserAddress();
        String expResult = "";
        String result = instance.getHome_address();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetHome_address() {
        System.out.println("setHome_address");
        String home_address = "";
        UserAddress instance = new UserAddress();
        instance.setHome_address(home_address);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDistrict() {
        System.out.println("getDistrict");
        UserAddress instance = new UserAddress();
        String expResult = "";
        String result = instance.getDistrict();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDistrict() {
        System.out.println("setDistrict");
        String district = "";
        UserAddress instance = new UserAddress();
        instance.setDistrict(district);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCity() {
        System.out.println("getCity");
        UserAddress instance = new UserAddress();
        String expResult = "";
        String result = instance.getCity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        UserAddress instance = new UserAddress();
        instance.setCity(city);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        UserAddress instance = new UserAddress();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
