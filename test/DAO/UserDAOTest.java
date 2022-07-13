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
import static org.junit.runner.Request.method;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
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
        ArrayList<User> expResult = null;
        ArrayList<User> result = instance.getUsersForAdminByName(namePattern);
        assertEquals(expResult, result);
        
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
        Mockito.doCallRealMethod().when(instance).editProfile(users_id, editUser, editUserAccount, editUserAddress);
        //<objectInstance>.<method>();
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
        
            //assertEquals(x, result);
         
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
        
    }

    /**
     * Test of resetPassword method, of class UserDAO.
     */
    @Test
    public void testResetPassword() {
        System.out.println("resetPassword");
        String username = "user1";
        UserDAO instance = new UserDAO();
        instance.resetPassword(username);
        UserAccount u =instance.getUserAccountById(1);
        assertEquals("12345", u.getPassword());

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
        assertNotNull(result);     
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
        assertNotNull(result);
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
        assertNotNull(result);
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
        
    }
    
}
