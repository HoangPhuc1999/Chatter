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
    private String phonenumber;
    private String email;
    private String gender;
    private String avatar;
    private ArrayList<Item> cart;

    public User(int users_id, String role, String phonenumber, String email, String gender, String avatar, ArrayList<Item> cart) {
        this.users_id = users_id;
        this.role = role;
        this.phonenumber = phonenumber;
        this.email = email;
        this.gender = gender;
        this.avatar = avatar;
        this.cart = cart;
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
    
    
    
    
}
