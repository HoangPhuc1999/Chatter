/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author khuat
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({model.ProductImageTest.class, model.ItemTest.class, model.UserDetailsTest.class, model.BookTest.class, model.ProductDetailsTest.class, model.AboutTest.class, model.ReviewTest.class, model.UserAddressTest.class, model.CategoryTest.class, model.ProductTest.class, model.UserRoleTest.class, model.OrderTest.class, model.UserTest.class, model.UserAccountTest.class})
public class ModelSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
