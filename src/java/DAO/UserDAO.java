package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    /**
     * author : Phuc,
     *
     * Phong: add user_role
     *
     * @param xUserName
     * @param xPass
     * @return
     */
    public UserAccount getUser(String xUserName, String xPass) {
        xSql = "select ua.users_id users_id, user_role\n"
                + "from users_account ua LEFT JOIN users_role ur ON ua.users_id = ur.users_id\n"
                + "where username = ? and password = ?";
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
                x.setRole(rs.getString("user_role"));

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
    //edit user profile.jsp
    //29/6 
    public void editProfile(int users_id, User editUser, UserAccount editUserAccount, UserAddress editUserAddress) {
        String query = "UPDATE users\n"
                + "SET firstname = ? , lastname= ? , phonenumber= ?, email= ?, gender= ?, avatar= ?\n"
                + "WHERE users_id = ?";
        String query2 = "UPDATE users_account\n"
                + "SET username = ?  ,password =?\n"
                + "WHERE users_id = ? ";
        String query3 = "UPDATE users_address"
                + "SET home_address = ? , district = ? , city = ? "
                + "WHERE users_id = ?";
        try {
            //edit users
            ps = con.prepareStatement(query);
            ps.setString(1, editUser.getFirstname());
            ps.setString(2, editUser.getLastname());
            ps.setString(3, editUser.getPhonenumber());
            ps.setString(4, editUser.getEmail());
            ps.setInt(5, editUser.getGenderNum());
            ps.setString(6, editUser.getAvatar());
            ps.setInt(7, users_id);
            ps.executeUpdate();
            ps.clearParameters();

            //edit  user_account
            ps = con.prepareStatement(query2);
            ps.setString(1, editUserAccount.getUsername());
            ps.setString(2, editUserAccount.getPassword());
            ps.setInt(3, users_id);
            ps.executeUpdate();
            ps.clearParameters();

            //edit user_address
            ps = con.prepareStatement(query3);
            ps.setString(1, editUserAddress.getHome_address());
            ps.setString(2, editUserAddress.getDistrict());
            ps.setString(3, editUserAddress.getCity());
            ps.setInt(4, users_id);
            ps.executeUpdate();
            ps.clearParameters();

            ps.close();
            rs.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
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
                + "Set password = '12345'\n"
                + "Where username = ?";
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
     * DoTuanPhong: update User dung de them user moi vao bang user
     *
     * @param user
     * @return cot vua duoc them
     */
    public int updateUserDetailsTousers(UserDetails user) {
        try {
            String sql = "UPDATE [users]\n"
                    + "   SET [firstname] = ?\n"
                    + "      ,[lastname] = ?\n"
                    + "      ,[phonenumber] = ?\n"
                    + "      ,[email] = ?\n"
                    + "      ,[gender] = ?\n"
                    + (user.getAvatar() == null ? "" : "      ,[avatar] = ?\n")
                    + " WHERE users_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getPhonenumber());
            statement.setString(4, user.getEmail());
            statement.setBoolean(5, user.getGender().equals("male"));
            if (user.getAvatar() == null) {
                statement.setInt(6, user.getUsers_id());
            } else {
                statement.setString(6, user.getAvatar());
                statement.setInt(7, user.getUsers_id());
            }

            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * DoTuanPhong: addUser dung de them user moi vao bang usersrole
     *
     * @param user
     * @return cot vua duoc sua
     */
    public int updateUserDetailsTousersRole(UserDetails user) {
        try {
            String sql = "UPDATE [users_role]\n"
                    + "   SET [user_role] = ?\n"
                    + " WHERE users_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getRole());
            statement.setInt(2, user.getUsers_id());

            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * DoTuanPhong: addUser dung de them user moi vao bang users_address
     *
     * @param user
     * @return cot vua duoc sua
     */
    public String updateUserDetailsTousersaddress(UserDetails user) {
        try {
            String sql = "UPDATE [users_address]\n"
                    + "   SET [home_address] = ?\n"
                    + "      ,[district] = ?\n"
                    + "      ,[city] = ?\n"
                    + " WHERE [users_id] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, user.getHome_address());
            statement.setString(2, user.getDistrict());
            statement.setString(3, user.getCity());
            statement.setInt(4, user.getUsers_id());

            int updateStat = statement.executeUpdate();
            if (updateStat == 0) {
                return "\nUpdate to users_address: " + updateStat
                        + "\nAdd to users_address: "
                        + addUserDetailsTousersaddress(user);
            }
            return "\nUpdate to users_address: " + updateStat;

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "\nUpdate to users_address: 0";
    }

    /**
     * DoTuanPhong: addUser dung de them user moi vao bang users_address
     *
     * @param user
     * @return cot vua duoc sua
     */
    public int addUserDetailsTousersaddress(UserDetails user) {
        try {
            String sql = "INSERT INTO [users_address]\n"
                    + "           ([users_id]\n"
                    + "           ,[home_address]\n"
                    + "           ,[district]\n"
                    + "           ,[city])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, user.getUsers_id());
            statement.setString(2, user.getHome_address());
            statement.setString(3, user.getDistrict());
            statement.setString(4, user.getCity());

            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * DoTuanPhong them account moi vao bang account
     *
     * @param account
     * @return cot moi them
     */
    public int addAccount(UserAccount account) {
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
            return ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * Do Tuan Phong: lay du lieu day du cua user bang userid
     *
     * @param userid
     * @return UserDetails
     */
    public UserDetails getUserDetailsById(int userid) {
        String query = "SELECT *\n"
                + "FROM users u LEFT JOIN users_role ur ON u.users_id = ur.users_id\n"
                + "RIGHT JOIN users_account uac ON u.users_id = uac.users_id\n"
                + "LEFT JOIN users_address uar ON u.users_id = uar.users_id\n"
                + "LEFT JOIN orders o ON u.users_id = o.order_by\n"
                + "LEFT JOIN orders_details od ON o.order_id = od.order_id\n"
                + "LEFT JOIN products p ON p.product_id  = od.order_product_id\n"
                + "LEFT JOIN products_image pi ON pi.product_id = p.product_id\n"
                + "WHERE u.users_id = ?";

        ArrayList<Order> orders = new ArrayList<>();
        Order order = new Order();
        UserDetails details = new UserDetails();

        try {
            ps = con.prepareStatement(query);

            ps.setInt(1, userid);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getInt("users_id") == 0) {
                    return null;
                }

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
                details.setCity(rs.getString("city"));

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

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }

    /**
     *
     * Do Tuan Phong: lay du lieu day du cua user bang userid
     *
     * @param userid
     * @return UserDetails
     */
    public List<UserDetails> getAllUserDetailses(int type, String[] searchValues, int pageindex, int pagesize) {
        ArrayList<UserDetails> userDetailses = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM users u LEFT JOIN users_role ur ON u.users_id = ur.users_id\n"
                + "RIGHT JOIN users_account uac ON u.users_id = uac.users_id\n"
                + "LEFT JOIN users_address uar ON u.users_id = uar.users_id\n";
        sql += "ORDER BY u.users_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, pageindex);
            ps.setInt(2, pagesize);

            rs = ps.executeQuery();

            while (rs.next()) {
                UserDetails details = new UserDetails();

                details.setUsers_id(rs.getInt("users_id"));
                details.setFirstname(rs.getString("firstname"));
                details.setLastname(rs.getString("lastname"));
                details.setPhonenumber(rs.getString("phonenumber"));
                details.setEmail(rs.getString("email"));
                details.setGender(rs.getBoolean("gender") ? "male" : "female");
                details.setAvatar(rs.getString("avatar"));
                details.setRole(rs.getString("user_role"));
                details.setAccount(new UserAccount(details.getUsers_id(), rs.getString("username"), null));
                details.setHome_address(rs.getString("home_address"));
                details.setDistrict(rs.getString("district"));
                details.setCity(rs.getString("city"));

                userDetailses.add(details);
            }
            return userDetailses;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);

        }
        return null;
    }
    
        /**
     * Do Tuan Phong
     *
     * tra ve so luong product trong ham getAllProducts
     *
     * @param type
     * @param strings
     * @return
     */
    public int countproducts(int type, String[] strings) {
        try {
            String sql = "SELECT *\n"
                + "FROM users u LEFT JOIN users_role ur ON u.users_id = ur.users_id\n"
                + "RIGHT JOIN users_account uac ON u.users_id = uac.users_id\n"
                + "LEFT JOIN users_address uar ON u.users_id = uar.users_id\n";

            sql = "SELECT COUNT(DISTINCT product_id) Total\n"
                    + "FROM(\n" + sql + ") pd";

            ps = connection.prepareStatement(sql);
//            if (strings[0] != null) {
//                if (strings[0].trim().length() != 0) {
//                    switch (type) {
//                        case 0:
//                        case 1:
//                            ps.setString(1, strings[0]);
//                            break;
//                        case 2:
//                            ps.setDouble(1, Double.parseDouble(strings[0]));
//                            ps.setDouble(2, Double.parseDouble(strings[1]));
//                            break;
//                        case 3:
//                            ps.setTimestamp(1, Timestamp.valueOf(strings[0]));
//                            ps.setTimestamp(2, Timestamp.valueOf(strings[1]));
//                            break;
//                        default:
//                            break;
//
//                    }
//                }
//            }

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<UserDetails> getAllUserDetailsesWithOrders(int type, String[] searchValues, int pageindex, int pagesize) {

        ArrayList<UserDetails> userDetailses = (ArrayList< UserDetails>) getAllUserDetailses(type, searchValues, pageindex, pagesize);
        for (UserDetails userDetails : userDetailses) {
            userDetails = getUserDetailsById(userDetails.getUsers_id());
        }
        return userDetailses;
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
        //check edit
//        UserAccount editAcc = new UserAccount("user1", "user1");
//        UserAddress eAccAddress = new UserAddress("Hoan kiem", "Hanoi", "Vietnam");
//        User eAccUser = new User("make", "gg", "0675565454", "user3@fpt.edu.vn", "0", null);
//        dao.editProfile(1, eAccUser, editAcc, eAccAddress);
//        System.out.println(dao.getUserFromId(1));
    }

}
