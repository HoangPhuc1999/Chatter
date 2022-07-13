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
public class UserAccountTest {
    
    public UserAccountTest() {
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
        UserAccount instance = new UserAccount();
        int expResult = 0;
        int result = instance.getUsers_id();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetUsers_id() {
        System.out.println("setUsers_id");
        int users_id = 0;
        UserAccount instance = new UserAccount();
        instance.setUsers_id(users_id);
        
    }

    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        UserAccount instance = new UserAccount();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        UserAccount instance = new UserAccount();
        instance.setUsername(username);
        
    }

    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        UserAccount instance = new UserAccount();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        UserAccount instance = new UserAccount();
        instance.setPassword(password);
        
    }

    @Test
    public void testGetRole() {
        System.out.println("getRole");
        UserAccount instance = new UserAccount();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        UserAccount instance = new UserAccount();
        instance.setRole(role);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        UserAccount instance = new UserAccount();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
