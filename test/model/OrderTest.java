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
public class OrderTest {
    
    public OrderTest() {
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
    public void testGetOrderid() {
        System.out.println("getOrderid");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderid();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrderid() {
        System.out.println("setOrderid");
        int orderid = 0;
        Order instance = new Order();
        instance.setOrderid(orderid);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrderaid() {
        System.out.println("getOrderaid");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderaid();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrderaid() {
        System.out.println("setOrderaid");
        int orderaid = 0;
        Order instance = new Order();
        instance.setOrderaid(orderaid);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrderpid() {
        System.out.println("getOrderpid");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderpid();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrderpid() {
        System.out.println("setOrderpid");
        int orderpid = 0;
        Order instance = new Order();
        instance.setOrderpid(orderpid);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrderamount() {
        System.out.println("getOrderamount");
        Order instance = new Order();
        int expResult = 0;
        int result = instance.getOrderamount();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrderamount() {
        System.out.println("setOrderamount");
        int orderamount = 0;
        Order instance = new Order();
        instance.setOrderamount(orderamount);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetOrderdate() {
        System.out.println("getOrderdate");
        Order instance = new Order();
        Date expResult = null;
        Date result = instance.getOrderdate();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetOrderdate() {
        System.out.println("setOrderdate");
        Date orderdate = null;
        Order instance = new Order();
        instance.setOrderdate(orderdate);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Order instance = new Order();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
