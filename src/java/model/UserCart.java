/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author KQuangAn
 */
public class UserCart {
    private int users_id;
    private int product_id;
    private int order_amount;
    private ArrayList<Item> cart;

    public UserCart(int users_id, int product_id, int order_amount) {
        this.users_id = users_id;
        this.product_id = product_id;
        this.order_amount = order_amount;
    }

    public int getUsers_id() {
        return users_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getOrder_amount() {
        return order_amount;
    }

    public void setOrder_amount(int order_amount) {
        this.order_amount = order_amount;
    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void setCart(ArrayList<Item> cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return "UserCart{" + "users_id=" + users_id + ", product_id=" + product_id + ", order_amount=" + order_amount + ", cart=" + cart + '}';
    }

   
    
    
}
