/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Tuan Phong
 * extend tu User
 * có thêm các truong Order
 * 
 */
public class UserDetails extends UserAddress {
    private Order order;

    public UserDetails() {
    }

    public UserDetails(Order order, int users_id, String home_address, String district, String city) {
        super(users_id, home_address, district, city);
        this.order = order;
    }

    public UserDetails(Order order, int users_id, String home_address, String district, String city, String role, String firstname, String lastname, String phonenumber, String email, String gender, String avatar, ArrayList<Item> cart) {
        super(users_id, home_address, district, city, role, firstname, lastname, phonenumber, email, gender, avatar, cart);
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    

    
    
}
