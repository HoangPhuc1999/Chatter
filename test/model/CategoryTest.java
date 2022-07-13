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
public class CategoryTest {
    
    public CategoryTest() {
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
    public void testGetCid() {
        System.out.println("getCid");
        Category instance = new Category();
        int expResult = 0;
        int result = instance.getCid();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetCid() {
        System.out.println("setCid");
        int cid = 0;
        Category instance = new Category();
        instance.setCid(cid);
        
    }

    @Test
    public void testGetCname() {
        System.out.println("getCname");
        Category instance = new Category();
        String expResult = "";
        String result = instance.getCname();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetCname() {
        System.out.println("setCname");
        String cname = "";
        Category instance = new Category();
        instance.setCname(cname);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Category instance = new Category();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
