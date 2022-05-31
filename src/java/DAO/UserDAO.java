/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;
import model.UserAccount;

/**
/**
 *
 * @author Hoang Phuc
 */
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public UserAccount getUser(String xId, String xPass) {
        xSql = "select * from Users where userid = ? and password = ?";
        String user_name;
        UserAccount x = null;
        int user_id;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xId);
            ps.setString(2, xPass);
            rs = ps.executeQuery();

            if (rs.next()) {
                user_name = rs.getString("username");
                user_id = Integer.parseInt(xId);
                x = new UserAccount(user_id, user_name, xPass);
            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }
    
        public ArrayList<User> getUsersForAdminByName(String namePattern){
        ArrayList<User> users = new ArrayList<>();
        try {
            xSql = "select *\n" +
                    "from users u join users_role ur on u.users_id = ur.users_id\n"+
//                    "left join users_cart uc on u.users_id = uc.users_id\n" +
                    (namePattern.length()>0?
                    "where (firstname + ' ' + lastname) like ('%' + ? + '%')\n":"")
                    + "order by u.users_id";
            ps = con.prepareStatement(xSql);
            
            if( namePattern.length()>0)
            ps.setString(1, namePattern);
            
            rs = ps.executeQuery();
            
            while (rs.next()) {
                
                users.add(
                        new User(
                            rs.getInt("users_id"),
                            rs.getString("user_role"), 
                            rs.getString("firstname"), 
                            rs.getString("lastname"), 
                            "0123456789", 
                            rs.getString("email"), 
                            rs.getBoolean("gender") == true ? "Male" : "Female", 
                            rs.getString("avatar"), 
                            null));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
        


}
