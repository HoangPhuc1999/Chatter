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
public class UserAddress extends User {

    private int users_id;
    private String home_address;
    private String district;
    private String city;

    public UserAddress(int users_id, String home_address, String district, String city) {
        this.users_id = users_id;
        this.home_address = home_address;
        this.district = district;
        this.city = city;
        super.setUsers_id(users_id);

    }

    public UserAddress(String home_address, String district, String city) {
        this.home_address = home_address;
        this.district = district;
        this.city = city;
        super.setUsers_id(users_id);

    }

    public UserAddress(int users_id, String home_address, String district, String city, String role, String firstname, String lastname, String phonenumber, String email, String gender, String avatar, ArrayList<Item> cart) {
        super(users_id, role, firstname, lastname, phonenumber, email, gender, avatar, cart);
        this.home_address = home_address;
        this.district = district;
        this.city = city;
        super.setUsers_id(users_id);

    }

    public UserAddress() {
    }

    @Override
    public int getUsers_id() {
        return users_id;
    }

    @Override
    public void setUsers_id(int users_id) {
        this.users_id = users_id;
        super.setUsers_id(users_id);
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User_Address{" + "users_id=" + users_id + ", home_address=" + home_address + ", district=" + district + ", city=" + city + '}' + ""
                + "/nUser: " + super.toString();
    }

}
