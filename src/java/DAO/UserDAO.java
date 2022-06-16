
package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import model.*;

/**
 * /**
 *
 * @author Hoang Phuc
 */
public class UserDAO extends DAO {

    //author : phuc 
    public UserAccount getUser(String xUserName, String xPass) {
        xSql = "select * from users_account where username = ? and password = ?";
        UserAccount x = null;
        int user_id;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, xUserName);
            ps.setString(2, xPass);
            rs = ps.executeQuery();

            if (rs.next()) {
                user_id = rs.getInt("users_id");
                x = new UserAccount(user_id, xUserName, xPass);
            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }

    public User getUserFromId(int id) {

        xSql = "select * from users where users_id = ?";
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                x = new User(rs.getInt("users_id"),
                        rs.getString("firstname"),
                        rs.getString("lastname"),
                        rs.getString("phonenumber"),
                        rs.getString("email"),
                        rs.getBoolean("gender") == true ? "Male" : "Female",
                        rs.getString("avatar")
                );

            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
    }

    //author: phong 
    public ArrayList<User> getUsersForAdminByName(String namePattern) {
        ArrayList<User> users = new ArrayList<>();
        try {
            xSql = "select *\n"
                    + "from users u join users_role ur on u.users_id = ur.users_id\n"
                    + //                    "left join users_cart uc on u.users_id = uc.users_id\n" +
                    (namePattern.length() > 0
                    ? "where (firstname + ' ' + lastname) like ('%' + ? + '%')\n" : "")
                    + "order by u.users_id";
            ps = con.prepareStatement(xSql);

            if (namePattern.length() > 0) {
                ps.setString(1, namePattern);
            }

            rs = ps.executeQuery();

            while (rs.next()) {
                
                users.add(
                        new User(
                                rs.getInt("users_id"),
                                rs.getString("user_role"),
                                rs.getString("firstname"),
                                rs.getString("lastname"),
                                rs.getString("phonenumber"),
                                rs.getString("email"),
                                rs.getBoolean("gender")? "Male" : "Female",
                                rs.getString("avatar"),
                                null)
                            );

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    //author: an 
    //Them user vao 4 bang User,user account, user address, user role
    //state: insert xong bang users thi dung lai
    public void singup(User newUser, UserAccount newUserAccount, UserAddress newUserAddress) {
        String query = "insert into users(firstname, lastname, phonenumber, email, gender, avatar)\n"
                + "values(?,?,?,?,?,?)";
        String idquery = "SELECT users_id \n"
                + "FROM users \n"
                + "WHERE users_id = (SELECT MAX(users_id) FROM Users)";

        String query2 = "insert into users_role(users_id,user_role)\n"
                + "values(?,?)";
        String query3 = "insert into users_account(users_id,username,password)\n"
                + "values(?,?,?)";
        String query4 = "insert into users_address(users_id,home_address,district,city)\n"
                + "values(?,?,?,?)";
        try {
            int users_id = 99999;
            //them vao users
            ps = con.prepareStatement(query);
            ps.setString(1, newUser.getFirstname());
            ps.setString(2, newUser.getLastname());
            ps.setString(3, newUser.getPhonenumber());
            ps.setString(4, newUser.getEmail());
            ps.setString(5, newUser.getGender());
            ps.setString(6, newUser.getAvatar());
            ps.executeUpdate();
            ps.clearParameters();

            ps = con.prepareStatement(idquery);
            rs = ps.executeQuery();
            while (rs.next()) {
                users_id = rs.getInt(1);
            }
            ps.clearParameters();

            //them vao user_role
            ps = con.prepareStatement(query2);
            ps.setInt(1, users_id);
            ps.setString(2, "user");
            ps.executeUpdate();
            ps.clearParameters();

            //them vao user_account
            ps = con.prepareStatement(query3);
            ps.setInt(1, users_id);
            ps.setString(2, newUserAccount.getUsername());
            ps.setString(3, newUserAccount.getPassword());
            ps.executeUpdate();
            ps.clearParameters();

            //them vao user_address
            ps = con.prepareStatement(query4);
            ps.setInt(1, users_id);
            ps.setString(2, newUserAddress.getHome_address());
            ps.setString(3, newUserAddress.getDistrict());
            ps.setString(4, newUserAddress.getCity());
            ps.executeUpdate();
            ps.clearParameters();

            ps.close();
            rs.close();

        } catch (Exception e) {
        }
    }
    //author: an 
    //lay tat ca info cua user tu 4 bang
    //state: insert xong bang users thi dung lai
    public void getAllUserInfoById(String users_id) {
        String query = "Select * from users where"
                + "users_id=?";
        String query2 = "Select * from users_role where"
                + "users_id=?";
        String query3 = "Select * from users_account where"
                + "users_id=?";
        String query4 = "Select * from users_address where"
                + "users_id=?";
        try {
            

            ps.close();
            rs.close();

        } catch (Exception e) {
        }
    }
    
    //author: an 
    //lay user role = usersid 
    public UserRole getUserRoleById(int users_id) {
        String query = "Select * from users_role where"
                + "users_id=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            ps.executeQuery();
            ps.clearParameters();
            while (rs.next()) {
                return new UserRole(rs.getInt(1),rs.getString(2));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            
        }
        return null;
    }
    
    //author: an 
    //lay user account = usersid 
    public UserAccount getUserAccountById(int users_id) {
        String query = "Select * from users_account where"
                + "users_id=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            ps.executeQuery();
            ps.clearParameters();
            while (rs.next()) {
                return new UserAccount(rs.getInt(1),rs.getString(2),rs.getString(3));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            
        }
        return null;
    }
    
    //author: an 
    //lay user address = usersid 
    public UserAddress getUserAddressById(int users_id) {
        String query = "Select * from users_address where"
                + "users_id=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            ps.executeQuery();
            ps.clearParameters();
            while (rs.next()) {
                return new UserAddress(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            
        }
        return null;
    }
    
    


    
    //author: an 
    //Lay users_id moi nhat sau khi insert user
    //old
    public int getUserIDold() throws SQLException {
        rs = ps.getGeneratedKeys();
        if (rs.next()) {
            int users_id = rs.getInt("ID");
            return users_id;
        }

        return 0;
    }

    //author: an 
    //Lay users_id moi nhat sau khi insert user = max
    public int getUserID() throws SQLException {
        String query = "SELECT users_id \n"
                + "FROM users \n"
                + "WHERE users_id = (SELECT MAX(users_id) FROM Users)";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 99999;
    }

    //author: an 
    //Kiem tra username da co chua
    public UserAccount checkAccountExist(String user) {
        String query = "select * from users_account\n"
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
    
    
    //check account username va email xem co trung k 
    //author : an 
    public Boolean checkAccountAndEmailMatch(String user,String email) {
        String query = "select * from users_account a Join users u "
                + "On u.users_id = a.users_id\n"
                + "where(username = ? and email = ?)\n" ;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    

    //reset mat khau table UserAccount 
    //Created by An at 27/5
    public void resetPassword(String username) {
        String query = "Update users_account\n"
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
    

    //lay tat ca user trong bang users 
    //author: an 
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUserList = new ArrayList<>();
        String query = "select * from users";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                allUserList.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
            
        }
        return allUserList;
    }
  
    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
        UserAccount a = new UserAccount();
        a = dao.checkAccountExist("user1");

//        //check sign up
//        UserAccount newAcc = new UserAccount("x","x");  
//        UserAddress newAccAddress= new UserAddress("x","x","x");
//        User newAccUser = new User("femmmmm","gqw","0675565454","user3@fpt.edu.vn","0",null);
//        
//        dao.singup(newAccUser,newAcc,newAccAddress); //them user
        
        
       ArrayList<User> b = dao.getAllUsers();
        
        int x = dao.getUserID();

        System.out.println(b);
    }

}
