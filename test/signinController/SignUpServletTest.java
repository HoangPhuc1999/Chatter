/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import DAO.UserDAO;
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
import org.mockito.MockitoAnnotations;
/**
 *
 * @author khuat
 */
public class SignUpServletTest {
     @Mock
    HttpServletRequest request;
 
    @Mock
    HttpServletResponse response;
    
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
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        SignUpServlet instance = new SignUpServlet();
        instance.doGet(request, response);
        
    }

    @Test
    public void testDoPostSignUpNormal() throws Exception {
        System.out.println("doPost");
        
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
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        SignUpServlet  signUpServlet =new SignUpServlet();
        signUpServlet.doPost(request, response);
        String result = sw.getBuffer().toString().trim();
        assertEquals(result, new String("Full Name: Vinod Kashyap"));
        
        
        
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        SignUpServlet instance = new SignUpServlet();
        instance.doPost(request, response);
        
    }
    
    @Test
    public void testDoPostSignUpWithoutUsername() throws Exception {
        System.out.println("doPost");
        
        when(request.getParameter("username")).thenReturn(null);
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("firstname")).thenReturn("testFirst");
        when(request.getParameter("lastname")).thenReturn("testLast");
        when(request.getParameter("phonenumber")).thenReturn("0123456789");
        when(request.getParameter("email")).thenReturn("testEmail@gmail.com");
        when(request.getParameter("gender")).thenReturn("1");
        when(request.getParameter("home_address")).thenReturn("testhome");
        when(request.getParameter("district")).thenReturn("testdistrict");
        when(request.getParameter("city")).thenReturn("testcity");
 
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
         
        when(response.getWriter()).thenReturn(pw);
 
        SignUpServlet  signUpServlet =new SignUpServlet();
        signUpServlet.doPost(request, response);
        String result = sw.getBuffer().toString().trim();
        assertEquals(result, new String("Full Name: Vinod Kashyap"));
        
        
        
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        SignUpServlet instance = new SignUpServlet();
        instance.doPost(request, response);
        
    }

    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        SignUpServlet instance = new SignUpServlet();
        instance.doPost(request, response);
        
    }
    
}
