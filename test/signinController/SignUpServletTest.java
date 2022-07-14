/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.UserDAO;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
 import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import org.mockito.MockitoAnnotations;
/**
 *
 * @author khuat
 */
public class SignUpServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    
    public SignUpServletTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    
    @After
    public void tearDown() {
    }

 

    @Test
    public void testDoPostSignUpNormal() throws Exception {
        System.out.println("doPost");     
        when(request.getParameter("avatar")).thenReturn("avatar/female");
        when(request.getParameter("username")).thenReturn("testUsername");
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("firstname")).thenReturn("testFirst");
        when(request.getParameter("lastname")).thenReturn("testLast");
        when(request.getParameter("phonenumber")).thenReturn("0123456789");
        when(request.getParameter("email")).thenReturn("testEmail@gmail.com");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("home_address")).thenReturn("testhome");
        when(request.getParameter("district")).thenReturn("testdistrict");
        when(request.getParameter("city")).thenReturn("testcity");

        SignUpServlet instance = new SignUpServlet();
        instance.doPost(request, response);
        
        
        
    }
    
    
    
    @Test(expected = IOException.class)
    public void testDoPostSignUpWithoutInvalidPhoneNumber() throws Exception {
        System.out.println("doPost");    
        when(request.getParameter("username")).thenReturn("testUserName");
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("firstname")).thenReturn("testFirst");
        when(request.getParameter("lastname")).thenReturn("testLast");
        when(request.getParameter("phonenumber")).thenReturn("012");
        when(request.getParameter("email")).thenReturn("testEmail@gmail.com");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("home_address")).thenReturn("testhome");
        when(request.getParameter("district")).thenReturn("testdistrict");
        when(request.getParameter("city")).thenReturn("testcity");

        SignUpServlet instance = new SignUpServlet();
        instance.doPost(request, response);
        
        
}
    
    
    
}
