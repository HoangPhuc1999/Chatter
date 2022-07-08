/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author An
 */
public class UserAccount {
    private int users_id;
    private String username;
    private String password;
    private String role;
    public UserAccount() {
    }

    public UserAccount(int users_id, String username, String password) {
        this.users_id = users_id;
        this.username = username;
        this.password = password;
    }

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }
    

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

    @Override
    public String toString() {
        return "UserAccount{" + "users_id=" + users_id + ", username=" + username + ", password=" + password + '}';
    }

    
    

    
}
