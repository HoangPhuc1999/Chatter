/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

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
@Suite.SuiteClasses({AboutDAOTest.class, OrderDAOTest.class, CartDAOTest.class, CategoryDAOTest.class, ProductDAOTest.class, DAOTest.class, ReviewDAOTest.class, MyDAOTest.class, BookDAOTest.class, UserDAOTest.class})
public class DAOSuite {

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
