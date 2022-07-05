/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author Hoang Phuc
 */
public class BookDAO extends DAO {
     public void insertBook(Book x) {
        xSql = "insert into booking values (?,?,?,?,?)";

        
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getName());
            ps.setString(2, x.getEmail());
            ps.setString(3, x.getPhoneNumber());
            ps.setInt(4, x.getUsersId());
            ps.setDate(5, x.getDob());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Book> getBookItem() {
        List<Book> t = new ArrayList<>();
        xSql = "select * from booking";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int book_id;
            String name;
            String email;
            String phonenumber;
            int person;
            Date dob;
            Book x;

            while (rs.next()) {
                book_id = rs.getInt("book_id");
                name = rs.getString("name");
                email = rs.getString("email");
                phonenumber = rs.getString("phonenumber");
                person = rs.getInt("users_id");
                dob = rs.getDate("book_time");

                x = new Book(book_id, name, email, phonenumber, person, dob);
                t.add(x);
            }

            rs.close();

            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
}
