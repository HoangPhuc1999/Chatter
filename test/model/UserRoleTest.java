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
public class UserRoleTest {
    
    public UserRoleTest() {
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
        UserRole instance = null;
        int expResult = 0;
        int result = instance.getUsers_id();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetUsers_id() {
        System.out.println("setUsers_id");
        int users_id = 0;
        UserRole instance = null;
        instance.setUsers_id(users_id);
        
    }

    @Test
    public void testGetRole() {
        System.out.println("getRole");
        UserRole instance = null;
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        UserRole instance = null;
        instance.setRole(role);
        
    }
    
}
