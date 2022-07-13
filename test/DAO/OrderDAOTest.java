/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.Item;
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
public class OrderDAOTest {
    
    public OrderDAOTest() {
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
     * Test of insertOrder method, of class OrderDAO.
     */
    @Test
    public void testInsertOrder() {
        System.out.println("insertOrder");
        ArrayList<Item> list = null;
        int users_id = 0;
        OrderDAO instance = new OrderDAO();
        instance.insertOrder(list, users_id);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
