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
public class ProductTest {
    
    public ProductTest() {
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
    public void testGetId() {
        System.out.println("getId");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Product instance = new Product();
        instance.setId(id);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetName() {
        System.out.println("getName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Product instance = new Product();
        instance.setName(name);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetImage() {
        System.out.println("getImage");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getImage();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetImage() {
        System.out.println("setImage");
        String image = "";
        Product instance = new Product();
        instance.setImage(image);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        Product instance = new Product();
        instance.setPrice(price);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Product instance = new Product();
        instance.setTitle(title);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Product instance = new Product();
        instance.setDescription(description);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetCname() {
        System.out.println("getCname");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getCname();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testSetCname() {
        System.out.println("setCname");
        String cname = "";
        Product instance = new Product();
        instance.setCname(cname);
        fail("The test case is a prototype.");
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
