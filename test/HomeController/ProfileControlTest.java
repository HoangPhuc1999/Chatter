/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HomeController;

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
public class ProfileControlTest {
    
    public ProfileControlTest() {
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
        ProfileControl instance = new ProfileControl();
        instance.processRequest(request, response);
        
    }

    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProfileControl instance = new ProfileControl();
        instance.doGet(request, response);
        
    }

    @Test
    public void testDoGet_EditProfile() throws Exception {
        System.out.println("doGet_EditProfile");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProfileControl instance = new ProfileControl();
        instance.doGet_EditProfile(request, response);
        
    }

    @Test
    public void testDoGet_DisplayProfile() throws Exception {
        System.out.println("doGet_DisplayProfile");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProfileControl instance = new ProfileControl();
        instance.doGet_DisplayProfile(request, response);
        
    }

    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ProfileControl instance = new ProfileControl();
        instance.doPost(request, response);
        
    }

    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        ProfileControl instance = new ProfileControl();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        
    }
    
}
