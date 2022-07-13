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
public class ReviewTest {
    
    public ReviewTest() {
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
    public void testGetName() {
        System.out.println("getName");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Review instance = new Review();
        instance.setName(name);
        
    }

    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetReviewContent() {
        System.out.println("getReviewContent");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getReviewContent();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetReviewImageUrl() {
        System.out.println("getReviewImageUrl");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getReviewImageUrl();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Review instance = new Review();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetReviewId() {
        System.out.println("getReviewId");
        Review instance = new Review();
        int expResult = 0;
        int result = instance.getReviewId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Review instance = new Review();
        int expResult = 0;
        int result = instance.getProductId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetRating() {
        System.out.println("getRating");
        Review instance = new Review();
        String expResult = "";
        String result = instance.getRating();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetUserId() {
        System.out.println("getUserId");
        Review instance = new Review();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Review instance = new Review();
        instance.setTitle(title);
        
    }

    @Test
    public void testSetReviewContent() {
        System.out.println("setReviewContent");
        String reviewContent = "";
        Review instance = new Review();
        instance.setReviewContent(reviewContent);
        
    }

    @Test
    public void testSetReviewImageUrl() {
        System.out.println("setReviewImageUrl");
        String url = "";
        Review instance = new Review();
        instance.setReviewImageUrl(url);
        
    }

    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Review instance = new Review();
        instance.setDate(date);
        
    }

    @Test
    public void testSetReviewId() {
        System.out.println("setReviewId");
        int id = 0;
        Review instance = new Review();
        instance.setReviewId(id);
        
    }

    @Test
    public void testSetProductId() {
        System.out.println("setProductId");
        int id = 0;
        Review instance = new Review();
        instance.setProductId(id);
        
    }

    @Test
    public void testSetRating() {
        System.out.println("setRating");
        String rating = "";
        Review instance = new Review();
        instance.setRating(rating);
        
    }

    @Test
    public void testSetUserId() {
        System.out.println("setUserId");
        int id = 0;
        Review instance = new Review();
        instance.setUserId(id);
        
    }
    
}
