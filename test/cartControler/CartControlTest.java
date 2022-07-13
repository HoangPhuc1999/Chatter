/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cartControler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class CartControlTest {
    
    public CartControlTest() {
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
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet(request, response);
        
    }

    @Test
    public void testDoGet_DisplayCart() throws Exception {
        System.out.println("doGet_DisplayCart");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet_DisplayCart(request, response);
        
    }

    @Test
    public void testDoGet_Remove() throws Exception {
        System.out.println("doGet_Remove");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet_Remove(request, response);
        
    }

    @Test
    public void testDoGet_Buy() throws Exception {
        System.out.println("doGet_Buy");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet_Buy(request, response);
        
    }

    @Test
    public void testDoGet_Add() throws Exception {
        System.out.println("doGet_Add");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet_Add(request, response);
        
    }

    @Test
    public void testDoGet_Discard() throws Exception {
        System.out.println("doGet_Discard");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doGet_Discard(request, response);
        
    }

    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CartControl instance = new CartControl();
        instance.doPost(request, response);
        
    }

    @Test
    public void testUpdateCartInDatabase() {
        System.out.println("updateCartInDatabase");
        User a = null;
        CartControl instance = new CartControl();
        instance.updateCartInDatabase(a);
        
    }
    
}
