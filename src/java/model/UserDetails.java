/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Tuan Phong
 * extend tu UserAddress
 * có thêm các truong Order
 * 
 */
public class UserDetails extends UserAddress {
    private ArrayList<Order> orders = new ArrayList<>();
    private UserAccount account;

    public UserDetails(int users_id, String home_address, String district, String city, String role, String firstname, String lastname, String phonenumber, String email, String gender, String avatar, ArrayList<Item> cart) {
        super(users_id, home_address, district, city, role, firstname, lastname, phonenumber, email, gender, avatar, cart);
        this.account.setUsers_id(users_id);
    }

    public UserDetails(UserAccount account, int users_id, String home_address, String district, String city, String role, String firstname, String lastname, String phonenumber, String email, String gender, String avatar, ArrayList<Item> cart) {
        super(users_id, home_address, district, city, role, firstname, lastname, phonenumber, email, gender, avatar, cart);
        this.account = account;
    }

    public UserDetails(UserAccount account) {
        this.account = account;
    }
    

    public UserDetails() {
    }

    public UserAccount getAccount() {
        return account;
    }

    public void setAccount(UserAccount account) {
        this.account = account;
    }
    

    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

  
    

    
    
}
