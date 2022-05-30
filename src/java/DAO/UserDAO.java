/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.User;
import model.UserAccount;

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

}
