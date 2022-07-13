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
public class UserTest {
    
    public UserTest() {
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
    public void testGetFirstname() {
        System.out.println("getFirstname");
        User instance = new User();
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "";
        User instance = new User();
        instance.setFirstname(firstname);
        
    }

    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        User instance = new User();
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "";
        User instance = new User();
        instance.setLastname(lastname);
        
    }

    @Test
    public void testGetUsers_id() {
        System.out.println("getUsers_id");
        User instance = new User();
        int expResult = 0;
        int result = instance.getUsers_id();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetUsers_id() {
        System.out.println("setUsers_id");
        int users_id = 0;
        User instance = new User();
        instance.setUsers_id(users_id);
        
    }

    @Test
    public void testGetRole() {
        System.out.println("getRole");
        User instance = new User();
        String expResult = "";
        String result = instance.getRole();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetRole() {
        System.out.println("setRole");
        String role = "";
        User instance = new User();
        instance.setRole(role);
        
    }

    @Test
    public void testGetPhonenumber() {
        System.out.println("getPhonenumber");
        User instance = new User();
        String expResult = "";
        String result = instance.getPhonenumber();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetPhonenumber() {
        System.out.println("setPhonenumber");
        String phonenumber = "";
        User instance = new User();
        instance.setPhonenumber(phonenumber);
        
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        
    }

    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User();
        String expResult = "";
        String result = instance.getGender();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        User instance = new User();
        instance.setGender(gender);
        
    }

    @Test
    public void testGetAvatar() {
        System.out.println("getAvatar");
        User instance = new User();
        String expResult = "";
        String result = instance.getAvatar();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetAvatar() {
        System.out.println("setAvatar");
        String avatar = "";
        User instance = new User();
        instance.setAvatar(avatar);
        
    }

    @Test
    public void testGetCart() {
        System.out.println("getCart");
        User instance = new User();
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getCart();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetCart() {
        System.out.println("setCart");
        ArrayList<Item> cart = null;
        User instance = new User();
        instance.setCart(cart);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        User instance = new User();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
