/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;
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
public class ProductDetailsTest {
    
    public ProductDetailsTest() {
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
    public void testGetQuantity() {
        System.out.println("getQuantity");
        ProductDetails instance = new ProductDetails();
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetQuantity() {
        System.out.println("setQuantity");
        int quantity = 0;
        ProductDetails instance = new ProductDetails();
        instance.setQuantity(quantity);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetModifyAt() {
        System.out.println("getModifyAt");
        ProductDetails instance = new ProductDetails();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getModifyAt();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetModifyAt() {
        System.out.println("setModifyAt");
        LocalDateTime modifyAt = null;
        ProductDetails instance = new ProductDetails();
        instance.setModifyAt(modifyAt);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCreateAt() {
        System.out.println("getCreateAt");
        ProductDetails instance = new ProductDetails();
        LocalDateTime expResult = null;
        LocalDateTime result = instance.getCreateAt();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCreateAt() {
        System.out.println("setCreateAt");
        LocalDateTime createAt = null;
        ProductDetails instance = new ProductDetails();
        instance.setCreateAt(createAt);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ProductDetails instance = new ProductDetails();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
