/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
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
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.MockitoJUnitRunner;


/**
 *
 * @author khuat
 */
@RunWith(MockitoJUnitRunner.class)
public class UserDAOTest {
    
    @Mock
    DataSource mockDataSource;
    @Mock
    Connection mockConn;
    @Mock
    PreparedStatement mockPreparedStmnt;
    @Mock
    ResultSet mockResultSet;
    
    private UserDAO udao = new UserDAO();
    
    public UserDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws SQLException {
       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUser method, of class UserDAO.
     * return user
     */
    @Test
    public void testGetUserThatExist() {
        System.out.println("getUserThatExist");
        String xUserName = "user1";
        String xPass = "user1";
        UserDAO instance = new UserDAO();
        UserAccount result = instance.getUser(xUserName, xPass);
        assertEquals("user1", result.getUsername());
        assertEquals("user1", result.getPassword());
    }
    
    /**
     * Test of getUser method, of class UserDAO.
     * return null
     */
    @Test
    public void testGetUserThatDoesNotExist() {
        System.out.println("getUserThatDoesNotExist");
        String xUserName = "user0";
        String xPass = "user1";
        UserDAO instance = new UserDAO();
        UserAccount result = instance.getUser(xUserName, xPass);
        assertNull(result);
    }

    /**
     * Test of getUserFromId method, of class UserDAO.
     */
    @Test
    public void testGetUserFromIdTrue() {
        System.out.println("getUserFromIdTrue");
        int id = 1;
        UserDAO instance = new UserDAO();
        User result = instance.getUserFromId(id);
        assertEquals(id, result.getUsers_id());
        
    }
    
    /**
     * Test of getUserFromId method, of class UserDAO.
     */
    @Test
    public void testGetUserFromIdNull() {
        System.out.println("getUserFromIdNull");
        int id = 0;
        UserDAO instance = new UserDAO();
        User expResult = null;
        User result = instance.getUserFromId(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getUsersForAdminByName method, of class UserDAO.
     */
    @Test
    public void testGetUsersForAdminByName() {
        System.out.println("getUsersForAdminByName");
        String namePattern = "user1 user1";
        UserDAO instance = new UserDAO();
        ArrayList<User> result = instance.getUsersForAdminByName(namePattern);
        assertEquals(namePattern, result.get(0).getFirstname());
        
    }
    
    /**
     * Test of getUsersForAdminByName method, of class UserDAO.
     */
    @Test
    public void testGetUsersForAdminByNameNull() {
        System.out.println("getUsersForAdminByName");
        String namePattern = "lmao lmao";
        UserDAO instance = new UserDAO();
        ArrayList<User> result = instance.getUsersForAdminByName(namePattern);
        assertTrue(result.isEmpty());
        
    }

    /**
     * Test of editProfile method, of class UserDAO.
     */
    @Test
    public void testEditProfile() {
        System.out.println("editProfile");
        int users_id = 1;
        User editUser = null;
        UserAccount editUserAccount = null;
        UserAddress editUserAddress = null;
        UserDAO instance = new UserDAO();
        instance.editProfile(users_id, editUser, editUserAccount, editUserAddress);
        
    }
    
    /**
     * Test of editProfile method, of class UserDAO.
     */
    @Test
    public void testEditProfileNullId() {
        System.out.println("editProfile");
        int users_id = 0;
        User editUser = null;
        UserAccount editUserAccount = null;
        UserAddress editUserAddress = null;
        UserDAO instance = new UserDAO();
        instance.editProfile(users_id, editUser, editUserAccount, editUserAddress);
        
    }

    /**
     * Test of singup method, of class UserDAO.
     */
    @Test
    public void testSignUp() {
        System.out.println("singup");
        UserAccount newAcc = new UserAccount("test1","test1");  
        UserAddress newAddress= new UserAddress("Hoan kiem","Hanoi","Vietnam");
        User newAccUser = new User("test","1","0675565454","test@fpt.edu.vn","0",null);
        UserDAO instance = new UserDAO();
        instance.singup(newAccUser, newAcc, newAddress);
        
        try {
            int newSignUpId = udao.getUserID();
            System.out.println(udao.getUserAddressById(newSignUpId));
            System.out.println(udao.getUserAccountById(newSignUpId));
            System.out.println(udao.getUserFromId(newSignUpId));
            
        }
        catch (SQLException ex) {
            Logger.getLogger(UserDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            assertEquals(x, result);

        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    

    /**
     * Test of getUserRoleById method, of class UserDAO.
     */
    @Test
    public void testGetUserRoleByIdTrue() {
        System.out.println("getUserRoleById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserRole expResult = new UserRole();
        UserRole result = instance.getUserRoleById(users_id);
        assertEquals(expResult, result);
    }
    /**
     * Test of getUserRoleById method, of class UserDAO.
     */
    @Test
    public void testGetUserRoleByIdFalse() {
        System.out.println("getUserRoleById");
        int users_id = 1;
        UserDAO instance = new UserDAO();
        UserRole expResult = null;
        UserRole result = instance.getUserRoleById(users_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserAccountById method, of class UserDAO.
     */
    @Test
    public void testGetUserAccountByIdTrue() {
        System.out.println("getUserAccountById");
        int users_id = 1;
        UserDAO instance = new UserDAO();
        UserAccount result = instance.getUserAccountById(users_id);
        assertEquals(users_id, result.getUsers_id());
    }
    
    /**
     * Test of getUserAccountById method, of class UserDAO.
     */
    @Test
    public void testGetUserAccountByIdFalse() {
        System.out.println("getUserAccountById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserAccount expResult = null;
        UserAccount result = instance.getUserAccountById(users_id);
        assertEquals(expResult, result);
 
    }

    /**
     * Test of getUserAddressById method, of class UserDAO.
     */
    @Test
    public void testGetUserAddressByIdTrue() {
        System.out.println("getUserAddressById");
        int users_id = 1;
        UserDAO instance = new UserDAO();
        UserAddress result = instance.getUserAddressById(users_id);
        assertEquals(users_id, result.getUsers_id());
       
    }
    /**
     * Test of getUserAddressById method, of class UserDAO.
     */
    @Test
    public void testGetUserAddressByIdFalse() {
        System.out.println("getUserAddressById");
        int users_id = 0;
        UserDAO instance = new UserDAO();
        UserAddress expResult = null;
        UserAddress result = instance.getUserAddressById(users_id);
        assertEquals(expResult, result);
       
    }



    /**
     * Test of getUserID method, of class UserDAO.
     */
    @Test
    public void testGetUserID() throws Exception {
        System.out.println("getUserID");
        UserDAO instance = new UserDAO();
        int result = instance.getUserID();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAccountExist method, of class UserDAO.
     */
    @Test
    public void testCheckAccountExistTrue() {
        System.out.println("checkAccountExist");
        String user = "user1";
        UserDAO instance = new UserDAO();
        UserAccount result = instance.checkAccountExist(user);
        assertEquals(user, result.getUsername());
    }
    
    /**
     * Test of checkAccountExist method, of class UserDAO.
     */
    @Test
    public void testCheckAccountExistFalse() {
        System.out.println("checkAccountExist");
        String user = "zioqevkdnfvjksdfnvskdj";
        UserDAO instance = new UserDAO();
        UserAccount expResult = null;
        UserAccount result = instance.checkAccountExist(user);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAccountAndEmailMatch method, of class UserDAO.
     */
    @Test
    public void testCheckAccountAndEmailMatchTrue() {
        System.out.println("checkAccountAndEmailMatch");
        String user = "user1";
        String email = "user1@fpt.edu.vn";
        UserDAO instance = new UserDAO();
        Boolean expResult = true;
        Boolean result = instance.checkAccountAndEmailMatch(user, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAccountAndEmailMatch method, of class UserDAO.
     */
    @Test
    public void testCheckAccountAndEmailMatchFalse() {
        System.out.println("checkAccountAndEmailMatch");
        String user = "qwjekfnqwejklf";
        String email = "wklefqwleknfqkwje";
        UserDAO instance = new UserDAO();
        Boolean expResult = false;
        Boolean result = instance.checkAccountAndEmailMatch(user, email);
        assertEquals(expResult, result);
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
        ArrayList<User> result = instance.getAllUsers();
        assertFalse(result.isEmpty());
    }

    /**
     * Test of getAllAccounts method, of class UserDAO.
     */
    @Test
    public void testGetAllAccounts() {
        System.out.println("getAllAccounts");
        UserDAO instance = new UserDAO();
        ArrayList<UserAccount> result = instance.getAllAccounts();
        assertFalse(result.isEmpty());
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
    }
    
}
