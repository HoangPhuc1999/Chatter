/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.Category;
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
public class CategoryDAOTest {
    
    public CategoryDAOTest() {
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
    public void testListAllCategory() {
        System.out.println("listAllCategory");
        CategoryDAO instance = new CategoryDAO();
        ArrayList<Category> expResult = null;
        ArrayList<Category> result = instance.listAllCategory();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testInsert() {
        System.out.println("insert");
        Category category = null;
        CategoryDAO instance = new CategoryDAO();
        instance.insert(category);
        fail("The test case is a prototype.");
    }

    @Test
    public void testUpdate() {
        System.out.println("update");
        Category category = null;
        CategoryDAO instance = new CategoryDAO();
        instance.update(category);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        int categoryId = 0;
        CategoryDAO instance = new CategoryDAO();
        instance.delete(categoryId);
        fail("The test case is a prototype.");
    }

    @Test
    public void testDeleteInProductsCategory() {
        System.out.println("deleteInProductsCategory");
        int categoryId = 0;
        CategoryDAO instance = new CategoryDAO();
        instance.deleteInProductsCategory(categoryId);
        fail("The test case is a prototype.");
    }
    
}
