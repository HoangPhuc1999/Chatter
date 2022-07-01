/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import model.User;
import model.UserAccount;
import model.UserAddress;
import model.UserDetails;
import model.UserRole;
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
public class UserDAOTest {
    
    public UserDAOTest() {
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
     * Test of getUser method, of class UserDAO.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        String xUserName = "";
        String xPass = "";
        UserDAO instance = new UserDAO();
        UserAccount expResult = null;
        UserAccount result = instance.getUser(xUserName, xPass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserFromId method, of class UserDAO.
     */
    @Test
    public void testGetUserFromId() {
        System.out.println("getUserFromId");
        int id = 0;
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserFromId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsersForAdminByName method, of class UserDAO.
     */
    @Test
    public void testGetUsersForAdminByName() {
        System.out.println("getUsersForAdminByName");
        String namePattern = "";
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUsersForAdminByName(namePattern);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editProfile method, of class UserDAO.
     */
    @Test
    public void testEditProfile() {
        System.out.println("editProfile");
        int users_id = 0;
        User editUser = null;
        UserAccount editUserAccount = null;
        UserAddress editUserAddress = null;
        UserDAO instance = new UserDAO();
        instance.editProfile(users_id, editUser, editUserAccount, editUserAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of singup method, of class UserDAO.
     */
    @Test
    public void testSingup() {
        System.out.println("singup");
        User newUser = null;
        UserAccount newUserAccount = null;
        UserAddress newUserAddress = null;
        UserDAO instance = new UserDAO();
        instance.singup(newUser, newUserAccount, newUserAddress);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserRoleById method, of class UserDAO.
     */
    @Test
    public void testGetUserRoleById() {
        System.out.println("getUserRoleById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserRole expResult = null;
        UserRole result = instance.getUserRoleById(users_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserAccountById method, of class UserDAO.
     */
    @Test
    public void testGetUserAccountById() {
        System.out.println("getUserAccountById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserAccount expResult = null;
        UserAccount result = instance.getUserAccountById(users_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserAddressById method, of class UserDAO.
     */
    @Test
    public void testGetUserAddressById() {
        System.out.println("getUserAddressById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserAddress expResult = null;
        UserAddress result = instance.getUserAddressById(users_id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIDold method, of class UserDAO.
     */
    @Test
    public void testGetUserIDold() throws Exception {
        System.out.println("getUserIDold");
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.getUserIDold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserID method, of class UserDAO.
     */
    @Test
    public void testGetUserID() throws Exception {
        System.out.println("getUserID");
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.getUserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAccountExist method, of class UserDAO.
     */
    @Test
    public void testCheckAccountExist() {
        System.out.println("checkAccountExist");
        String user = "";
        UserDAO instance = new UserDAO();
        UserAccount expResult = null;
        UserAccount result = instance.checkAccountExist(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkAccountAndEmailMatch method, of class UserDAO.
     */
    @Test
    public void testCheckAccountAndEmailMatch() {
        System.out.println("checkAccountAndEmailMatch");
        String user = "";
        String email = "";
        UserDAO instance = new UserDAO();
        Boolean expResult = null;
        Boolean result = instance.checkAccountAndEmailMatch(user, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPassword method, of class UserDAO.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String username = "";
        UserDAO instance = new UserDAO();
        instance.resetPassword(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllUsers method, of class UserDAO.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserDAO instance = new UserDAO();
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getAllUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllAccounts method, of class UserDAO.
     */
    @Test
    public void testGetAllAccounts() {
        System.out.println("getAllAccounts");
        UserDAO instance = new UserDAO();
        ArrayList<UserAccount> expResult = null;
        ArrayList<UserAccount> result = instance.getAllAccounts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class UserDAO.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        UserDAO instance = new UserDAO();
        int expResult = 0;
        int result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAccount method, of class UserDAO.
     */
    @Test
    public void testAddAccount() {
        System.out.println("addAccount");
        UserAccount account = null;
        UserDAO instance = new UserDAO();
        instance.addAccount(account);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserDetailsById method, of class UserDAO.
     */
    @Test
    public void testGetUserDetailsById() {
        System.out.println("getUserDetailsById");
        int userid = 0;
        UserDAO instance = new UserDAO();
        UserDetails expResult = null;
        UserDetails result = instance.getUserDetailsById(userid);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class UserDAO.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        UserDAO.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
