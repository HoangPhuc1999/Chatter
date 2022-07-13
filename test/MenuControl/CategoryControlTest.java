/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuControl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class CategoryControlTest {
    
    public CategoryControlTest() {
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
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CategoryControl instance = new CategoryControl();
        instance.processRequest(request, response);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CategoryControl instance = new CategoryControl();
        instance.doGet(request, response);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CategoryControl instance = new CategoryControl();
        instance.doPost(request, response);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        CategoryControl instance = new CategoryControl();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
