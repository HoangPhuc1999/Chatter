/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author khuat
 */
public class User {
    private int users_id;
    private String role;
    private String firstname;
    private String lastname;
    private String phonenumber;
    private String email;
    private String gender;
    private String avatar;
    private ArrayList<Item> cart;


    public User(String firstname, String lastname, String phonenumber, String email, String gender, String avatar) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User(int users_id, String firstname, String lastname, String phonenumber, String email, String gender, String avatar) {
        this.users_id = users_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
    }

    public User(int users_id, String role, String firstname, String lastname, String phonenumber, String email, String gender, String avatar) {
        this.users_id = users_id;
        this.role = role;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
    }

    
    
    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "User{" + "users_id=" + users_id + ", role=" + role + ", firstname=" + firstname + ", lastname=" + lastname + ", phonenumber=" + phonenumber + ", email=" + email + ", gender=" + gender + ", avatar=" + avatar + ", cart=" + cart + '}';
    }
    
  
  
    
    
    
}
