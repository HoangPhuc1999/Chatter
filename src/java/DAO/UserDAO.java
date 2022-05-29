/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.User;
import model.User_Account;

/**
 *
 * @author Hoang Phuc
 */
public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User_Account getUser(String xId, String xPass) {
        xSql = "select * from Users where userid = ? and password = ?";
        String user_name;
        User_Account x = null;
        int user_id;
        try {
            ps = conn.prepareStatement(xSql);
            ps.setString(1, xId);
            ps.setString(2, xPass);
            rs = ps.executeQuery();

            if (rs.next()) {
                user_name = rs.getString("username");
                user_id = Integer.parseInt(xId);
                x = new User_Account(user_id,user_name, xPass);
            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }

}
