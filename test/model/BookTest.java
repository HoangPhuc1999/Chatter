/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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
public class BookTest {
    
    public BookTest() {
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
    public void testGetBookId() {
        System.out.println("getBookId");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.getBookId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Book instance = new Book();
        String expResult = "";
        String result = instance.getPhoneNumber();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetUsersId() {
        System.out.println("getUsersId");
        Book instance = new Book();
        int expResult = 0;
        int result = instance.getUsersId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Book instance = new Book();
        Date expResult = null;
        Date result = instance.getDob();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetBookId() {
        System.out.println("setBookId");
        int book_id = 0;
        Book instance = new Book();
        instance.setBookId(book_id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Book instance = new Book();
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Book instance = new Book();
        instance.setEmail(email);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        String phonenumber = "";
        Book instance = new Book();
        instance.setPhoneNumber(phonenumber);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPerson() {
        System.out.println("setPerson");
        int person = 0;
        Book instance = new Book();
        instance.setPerson(person);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDob() {
        System.out.println("setDob");
        Date dob = null;
        Book instance = new Book();
        instance.setDob(dob);
        fail("The test case is a prototype.");
    }
    
}
