/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
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
public class ProductImageTest {
    
    public ProductImageTest() {
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
        ProductImage instance = new ProductImage();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        ProductImage instance = new ProductImage();
        instance.setId(id);
        
    }

    @Test
    public void testGetImageUrl() {
        System.out.println("getImageUrl");
        ProductImage instance = new ProductImage();
        String expResult = "";
        String result = instance.getImageUrl();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetImageUrl() {
        System.out.println("setImageUrl");
        String url = "";
        ProductImage instance = new ProductImage();
        instance.setImageUrl(url);
        
    }

    @Test
    public void testGetDate() {
        System.out.println("getDate");
        ProductImage instance = new ProductImage();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date dateTime = null;
        ProductImage instance = new ProductImage();
        instance.setDate(dateTime);
        
    }

    @Test
    public void testGetCategorys() {
        System.out.println("getCategorys");
        ProductImage instance = new ProductImage();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.getCategorys();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetCategorys() {
        System.out.println("setCategorys");
        ArrayList<Category> categorys = null;
        ProductImage instance = new ProductImage();
        instance.setCategorys(categorys);
        
    }

    @Test
    public void testToString() {
        System.out.println("toString");
        ProductImage instance = new ProductImage();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        
    }
    
}
