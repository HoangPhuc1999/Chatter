/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Hoang Phuc
 */
public class Book {

    private int book_id;
    private String name;
    private String email;
    private String phonenumber;
    private int users_id;
    private Date book_time;

    public Book() {
    }

    public Book(int book_id, String name, String email, String phonenumber, int users_id, Date book_time) {
        this.book_id = book_id;
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.users_id = users_id;
        this.book_time = book_time;
    }

    public int getBookId() {
        return book_id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phonenumber;
    }

    public int getUsersId() {
        return users_id;
    }

    public Date getDob() {
        return book_time;
    }

    public void setBookId(int book_id) {
        this.book_id = book_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setPerson(int person) {
        this.users_id = person;
    }

    public void setDob(Date dob) {
        this.book_time = dob;
    }
}
