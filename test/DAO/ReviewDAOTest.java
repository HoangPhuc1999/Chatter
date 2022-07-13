/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Review;
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
public class ReviewDAOTest {
    
    public ReviewDAOTest() {
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

    /**
     * Test of postReview method, of class ReviewDAO.
     */
    @Test
    public void testPostReview() {
        System.out.println("postReview");
        Review reviewItem = null;
        ReviewDAO instance = new ReviewDAO();
        instance.postReview(reviewItem);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    @Test
    public void testGetAllReviews() {
        System.out.println("getAllReviews");
        ReviewDAO instance = new ReviewDAO();
        List<Review> expResult = null;
        List<Review> result = instance.getAllReviews();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetAllReviewsFromId() {
        System.out.println("getAllReviewsFromId");
        String id = "";
        ReviewDAO instance = new ReviewDAO();
        List<Review> expResult = null;
        List<Review> result = instance.getAllReviewsFromId(id);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testGetReviewAuthor() {
        System.out.println("getReviewAuthor");
        int id = 0;
        ReviewDAO instance = new ReviewDAO();
        String expResult = "";
        String result = instance.getReviewAuthor(id);
        assertEquals(expResult, result);
        
    }
    
}
