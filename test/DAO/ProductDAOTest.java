/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.List;
import model.Category;
import model.Product;
import model.ProductDetails;
import model.ProductImage;
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
public class ProductDAOTest {
    
    public ProductDAOTest() {
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
     * Test of getProductById method, of class ProductDAO.
     */
    @Test
    public void testGetProductById() {
        System.out.println("getProductById");
        String id = "";
        ProductDAO instance = new ProductDAO();
        Product expResult = null;
        Product result = instance.getProductById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProduct method, of class ProductDAO.
     */
    @Test
    public void testGetAllProduct() {
        System.out.println("getAllProduct");
        ProductDAO instance = new ProductDAO();
        List<Product> expResult = null;
        List<Product> result = instance.getAllProduct();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProductWithCategory method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductWithCategory() {
        System.out.println("getAllProductWithCategory");
        ProductDAO instance = new ProductDAO();
        List<Product> expResult = null;
        List<Product> result = instance.getAllProductWithCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductImageById method, of class ProductDAO.
     */
    @Test
    public void testGetProductImageById() {
        System.out.println("getProductImageById");
        String id = "";
        ProductDAO instance = new ProductDAO();
        ProductImage expResult = null;
        ProductImage result = instance.getProductImageById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCategory method, of class ProductDAO.
     */
    @Test
    public void testGetAllCategory() {
        System.out.println("getAllCategory");
        ProductDAO instance = new ProductDAO();
        List<Category> expResult = null;
        List<Category> result = instance.getAllCategory();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductByCID method, of class ProductDAO.
     */
    @Test
    public void testGetProductByCID() {
        System.out.println("getProductByCID");
        String cid = "";
        ProductDAO instance = new ProductDAO();
        List<Product> expResult = null;
        List<Product> result = instance.getProductByCID(cid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of couponCheck method, of class ProductDAO.
     */
    @Test
    public void testCouponCheck() {
        System.out.println("couponCheck");
        String code = "";
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        int result = instance.couponCheck(code);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllProductDetailses method, of class ProductDAO.
     */
    @Test
    public void testGetAllProductDetailses() {
        System.out.println("getAllProductDetailses");
        ProductDAO instance = new ProductDAO();
        List<ProductDetails> expResult = null;
        List<ProductDetails> result = instance.getAllProductDetailses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class ProductDAO.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ProductDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProductDetailsToProducts() {
        System.out.println("addProductDetailsToProducts");
        ProductDetails pd = null;
        ProductDAO instance = new ProductDAO();
        int expResult = 0;
        int result = instance.addProductDetailsToProducts(pd);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProductDetailsToProductsImage() {
        System.out.println("addProductDetailsToProductsImage");
        ProductDetails pd = null;
        ProductDAO instance = new ProductDAO();
        boolean expResult = false;
        boolean result = instance.addProductDetailsToProductsImage(pd);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProductDetailsToProductsInventory() {
        System.out.println("addProductDetailsToProductsInventory");
        ProductDetails pd = null;
        ProductDAO instance = new ProductDAO();
        boolean expResult = false;
        boolean result = instance.addProductDetailsToProductsInventory(pd);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testAddProductDetailsToProductsCategory() {
        System.out.println("addProductDetailsToProductsCategory");
        ProductDetails pd = null;
        ProductDAO instance = new ProductDAO();
        boolean expResult = false;
        boolean result = instance.addProductDetailsToProductsCategory(pd);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
