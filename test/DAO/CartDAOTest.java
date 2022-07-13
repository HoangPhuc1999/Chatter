/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Item;
import model.User;
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
public class CartDAOTest {
    
    public CartDAOTest() {
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
     * Test of deleteCartAfterBuy method, of class CartDAO.
     */
    @Test(expected = Exception.class)
    public void testDeleteCartAfterBuy() {
        System.out.println("deleteCartAfterBuy");
        User a = new User();
        CartDAO instance = new CartDAO();
        instance.deleteCartAfterBuy(a);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of updateCartInDB method, of class CartDAO.
     */
    @Test
    public void testUpdateCartInDB() {
        System.out.println("updateCartInDB");
        int users_id = 0;
        int product_id = 0;
        int amount = 0;
        CartDAO instance = new CartDAO();
        instance.updateCartInDB(users_id, product_id, amount);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCart method, of class CartDAO.
     */
    @Test
    public void testGetCart() {
        System.out.println("getCart");
        int users_id = 1;
        CartDAO instance = new CartDAO();
        List<Item> expResult = null;
        List<Item> result = instance.getCart(users_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of main method, of class CartDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        CartDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
