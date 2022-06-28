package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    /**
     * lay nguoi dung boi ten
     *
     * @param namePattern
     * @return ArrayList<User>
     */
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
                                rs.getBoolean("gender") ? "male" : "female",
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
    //lay user role = usersid 
    public UserRole getUserRoleById(int users_id) {
        String query = "Select * from users_role where users_id=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserRole(rs.getInt(1), rs.getString(2));
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
        String query = "Select * from users_account where users_id =?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserAccount(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            ps.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    //author: an 
    //lay user address = usersid 
    public UserAddress getUserAddressById(int users_id) {
        String query = "Select * from users_address where users_id=?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new UserAddress(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
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
    public Boolean checkAccountAndEmailMatch(String user, String email) {
        String query = "select * from users_account a Join users u "
                + "On u.users_id = a.users_id\n"
                + "where(username = ? and email = ?)\n";
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

    public ArrayList<UserAccount> getAllAccounts() {
        ArrayList<UserAccount> accounts = new ArrayList<>();
        String query = "select * from users_account";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                accounts.add(new UserAccount(rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }

    /**
     * DoTuanPhong: addUser dung de them user moi vao bang user va them role cua
     * user vao bang row
     *
     * @param user
     * @return userid vua moi duoc tao ra
     */
    public int addUser(User user) {
        int userid = 0;
        try {
            String sql = "INSERT INTO [users]\n"
                    + "           ([firstname]\n"
                    + "           ,[lastname]\n"
                    + "           ,[phonenumber]\n"
                    + "           ,[email]\n"
                    + "           ,[gender]\n"
                    + "           ,[avatar])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, user.getFirstname() == null || user.getFirstname().trim().length() == 0 ? "Your first name" : user.getFirstname());
            statement.setString(2, user.getLastname() == null || user.getLastname().trim().length() == 0 ? "Your last name" : user.getLastname());
            statement.setString(3, user.getPhonenumber());
            statement.setString(4, user.getEmail());
            statement.setBoolean(5, user.getGender().equals("male"));
            statement.setString(6, user.getAvatar());

            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            while (resultSet.next()) {
                userid = resultSet.getInt(1);
                xSql = "INSERT INTO [users_role]\n"
                        + "           ([users_id]\n"
                        + "           ,[user_role])\n"
                        + "     VALUES\n"
                        + "           (?\n"
                        + "           ,?)";
                PreparedStatement prepareStatement = connection.prepareStatement(xSql);
                prepareStatement.setInt(1, userid);
                prepareStatement.setString(2, user.getRole());
                prepareStatement.executeUpdate();

            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userid;
    }

    /**
     * DoTuanPhong them account moi vao bang account
     *
     * @param account
     */
    public void addAccount(UserAccount account) {
        try {
            String sql = "INSERT INTO [users_account]\n"
                    + "           ([users_id]\n"
                    + "           ,[username]\n"
                    + "           ,[password])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, account.getUsers_id());
            ps.setString(2, account.getUsername());
            ps.setString(3, account.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * Do Tuan Phong: lay du lieu day du cua user bang userid chac la xong, chua
     * check
     *
     * @param userid
     * @return UserDetails
     */
    public UserDetails getUserDetailsById(int userid) {
        String query = "SELECT *\n"
                + "FROM users u LEFT JOIN users_role ur on u.users_id = ur.users_id\n"
                + "RIGHT JOIN users_account uac on u.users_id = uac.users_id\n"
                + "LEFT JOIN users_address uar on u.users_id = uar.users_id\n"
                + "LEFT JOIN orders o on u.users_id = o.order_by\n"
                + "LEFT JOIN orders_details od on o.order_id = od.order_id\n"
                + "LEFT JOIN products p on p.product_id  = od.order_product_id\n"
                + "LEFT JOIN products_image pi on pi.product_id = p.product_id\n"
                + "WHERE u.users_id = ?";

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        UserDetails details = new UserDetails();

        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, userid);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt(1) == 0) {
                    return null;
                } else {
                    details.setUsers_id(userid);
                    details.setFirstname(rs.getString("firstname"));
                    details.setLastname(rs.getString("lastname"));
                    details.setPhonenumber(rs.getString("phonenumber"));
                    details.setEmail(rs.getString("email"));
                    details.setGender(rs.getBoolean("gender") ? "male" : "female");
                    details.setAvatar(rs.getString("avatar"));
                    details.setRole(rs.getString("user_role"));
                    details.setAccount(new UserAccount(userid, rs.getString("username"), null));
                    details.setHome_address(rs.getString("home_address"));
                    details.setDistrict(rs.getString("district"));
                    details.setCity("city");

                    if (rs.getInt(17) == 0) {
                        return details;
                    }

                    order.setOrderid(rs.getInt(17));
                    order.setOrderpid(rs.getInt("order_product_id"));
                    order.setOrderamount(rs.getInt("order_amount"));
                    order.setOrderdate(rs.getDate("order_date"));
                    order.setName(rs.getString("product_name"));
                    order.setPrice(rs.getDouble("product_price"));
                    order.setTitle(rs.getString("product_title"));
                    order.setDescription(rs.getString("product_description"));
                    order.setImageUrl(rs.getString("product_image_path"));
                    order.setDate(rs.getDate("modified_at"));

                    orders.add(order);
                    details.setOrders(orders);

                }
                while (rs.next()) {
                    Order order1 = new Order();
                    order1.setOrderid(rs.getInt(17));
                    order1.setOrderpid(rs.getInt("order_product_id"));
                    order1.setOrderamount(rs.getInt("order_amount"));
                    order1.setOrderdate(rs.getDate("order_date"));
                    order1.setName(rs.getString("product_name"));
                    order1.setPrice(rs.getDouble("product_price"));
                    order1.setTitle(rs.getString("product_title"));
                    order1.setDescription(rs.getString("product_description"));
                    order1.setImageUrl(rs.getString("product_image_path"));
                    order1.setDate(rs.getDate("modified_at"));

                    orders.add(order1);
                    details.setOrders(orders);
                }
                return details;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        UserDAO dao = new UserDAO();
//        UserAccount a = new UserAccount();
//        a = dao.checkAccountExist("user1");

//        //check sign up
//        UserAccount newAcc = new UserAccount("x","x");  
//        UserAddress newAccAddress= new UserAddress("x","x","x");
//        User newAccUser = new User("femmmmm","gqw","0675565454","user3@fpt.edu.vn","0",null);
//        
//        dao.singup(newAccUser,newAcc,newAccAddress); //them user
//        
//        
//       ArrayList<UserAccount> b = dao.getAllAccounts();
//        for (UserAccount userAccount : b) {
//            logger.log(Level.SEVERE, userAccount.getUsername());
//        }
//        
//        int x = dao.getUserID();
//        
//        System.out.println(dao.getUserAddressById(1));
//        System.out.println(dao.getUserAccountById(1));
//        System.out.println(dao.getUserRoleById(1));
//        System.out.println(dao.getUserFromId(1));
    }

}
