/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import model.*;


/**
 *
 * @author khuat
 */
public class DAO extends MyDAO{

    //author: an 
    //Them user vao 3 bang
    public void singup(User newUser,UserRole newUserRole,UserAccount newUserAccount){
        String query = "insert into users(firstname, lastname, email, gender)\n"
                + "values(?,?,?,?)";
        String query2 = "insert into users_role(users_id,user_role)\n"
                + "values(?,'user')";
        String query3 = "insert into users_account(users_id,username,password)\n"
                + "values(?,?)";
        try {
            //them vao users
            ps = con.prepareStatement(query);
            ps.setString(1, newUser.getFirstname());
            ps.setString(2, newUser.getLastname());
            ps.setString(3, newUser.getEmail());
            ps.setString(4, newUser.getGender());
            ps.executeUpdate();
            
            //them vao user_role
            ps = con.prepareStatement(query2);
            ps.setInt(1,newUserRole.getUsers_id() );
            ps.executeUpdate();
            
            //them vao user_account
            ps = con.prepareStatement(query3);
            ps.setString(1,newUserAccount.getUsername());
            ps.setString(2,newUserAccount.getPassword());
            ps.executeUpdate();
            
        } catch (Exception e) {
        }
    }
    
    //author: an 
    //Kiem tra username da co chua
    public UserAccount checkAccountExist(String user) {
        String query = "select * from User_Accounts\n"
                + "where Username = ?\n";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserAccount(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    //reset mat khau table UserAccount 
    //Created by An at 27/5
    public void resetPassword(String username) {
        String query = "Update User_Accounts\n"
                + "Set Password = !@#$%"
                + "where Username = ?\n"
                + "";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.executeUpdate(query);
        } catch (Exception e) {

        }
    }
      
    
}
