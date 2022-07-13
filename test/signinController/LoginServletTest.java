/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signinController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import junit.framework.TestCase;

import org.junit.Test;
import org.mockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 *
 * @author khuat
 */
public class LoginServletTest {
    
    public LoginServletTest() {
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
        LoginServlet instance = new LoginServlet();
        instance.doGet(request, response);
        fail("The test case is a prototype.");
    }

    @Test
    public void testLoginNull() throws Exception {
        HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
        HttpSession stubHttpSession = mock(HttpSession.class);
        when(stubHttpServletRequest.getParameter("name")).thenReturn("a");
        when(stubHttpServletRequest.getParameter("pass")).thenReturn("a");
        when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
        when(stubHttpSession.getAttribute("name")).thenReturn("ef");

        LoginServlet instance = new LoginServlet();
        instance.doPost(stubHttpServletRequest, stubHttpServletResponse);
    }
    @Test
    public void testLoginValid() throws Exception {
        HttpServletRequest stubHttpServletRequest = mock(HttpServletRequest.class);
        HttpServletResponse stubHttpServletResponse = mock(HttpServletResponse.class);
        HttpSession stubHttpSession = mock(HttpSession.class);
        when(stubHttpServletRequest.getParameter("name")).thenReturn("a");
        when(stubHttpServletRequest.getParameter("pass")).thenReturn("a");
        when(stubHttpServletRequest.getSession()).thenReturn(stubHttpSession);
        when(stubHttpSession.getAttribute("name")).thenReturn("ef");

        LoginServlet instance = new LoginServlet();
        instance.doPost(stubHttpServletRequest, stubHttpServletResponse);
    }
    
    
}
