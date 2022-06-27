/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author khuat
 */
public class Order extends ProductImage{
    private int orderid; 
    private int orderaid;
    private int orderpid;
    private int orderamount;
    private Date orderdate;

    public Order(int orderid, int orderaid, int orderpid, int orderamount, Date orderdate) {
        super();
        this.orderid = orderid;
        this.orderaid = orderaid;
        this.orderpid = orderpid;
        this.orderamount = orderamount;
        this.orderdate = orderdate;
        super.setId(orderpid);
        
    }

    public Order(int orderid, int orderaid, int orderpid, int orderamount, Date orderdate, String imageUrl, Date dateTime, int id, String name, String image, double price, String title, String description, String cname) {
        super(imageUrl, dateTime, id, name, image, price, title, description, cname);
        this.orderid = orderid;
        this.orderaid = orderaid;
        this.orderpid = orderpid;
        this.orderamount = orderamount;
        this.orderdate = orderdate;
        
        super.setId(orderpid);
    }

    public Order() {
    }
    

    

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public int getOrderaid() {
        return orderaid;
    }

    public void setOrderaid(int orderaid) {
        this.orderaid = orderaid;
    }

    public int getOrderpid() {
        return orderpid;
    }

    public void setOrderpid(int orderpid) {
        this.orderpid = orderpid;
        
        super.setId(orderpid);
    }

    public int getOrderamount() {
        return orderamount;
    }

    public void setOrderamount(int orderamount) {
        this.orderamount = orderamount;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    
    @Override
    public String toString() {
        return "Order{" + "orderid=" + orderid + ", orderaid=" + orderaid + ", orderpid=" + orderpid + ", orderamount=" + orderamount + ", orderdate=" + orderdate + '}';
    }


    
}
