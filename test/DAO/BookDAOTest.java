/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Book;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author khuat
 */
public class BookDAOTest {
    
    public BookDAOTest() {
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
    public void testInsertBook() {
        System.out.println("insertBook test ");
        Book bookMock = mock(Book.class);
        when(bookMock.retrieveAllData()).thenReturn();
        BookDAO instance = new BookDAO();
        instance.insertBook(x);
        
    }

    @Test
    public void testGetBookItem() {
        System.out.println("getBookItem");
        BookDAO instance = new BookDAO();
        List<Book> expResult = null;
        List<Book> result = instance.getBookItem();
        assertEquals(expResult, result);
        
    }

    @Test
    public void testSearchBookItem() {
        System.out.println("searchBookItem");
        String phonenumber = "";
        BookDAO instance = new BookDAO();
        List<Book> expResult = null;
        List<Book> result = instance.searchBookItem(phonenumber);
        assertEquals(expResult, result);
        
    }
    
}
