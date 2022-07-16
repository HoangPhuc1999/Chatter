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
public class OrderDetail {

    private int order_id;
    private int order_product_id;
    private int order_amount;
    private Date order_date;
    private String product_name;
    private String product_image_path;

    public int getOrderId() {
        return order_id;
    }

    public int getOrderProductId() {
        return order_product_id;
    }

    public int getOrderAmount() {
        return order_amount;
    }

    public Date getOrderDate() {
        return order_date;
    }

    public String getProductName() {
        return product_name;
    }

    public String getProductImagePath() {
        return product_image_path;
    }

    public void setOrderId(int id) {
        order_id = id;
    }

    public void setOrderProductId(int id) {
        order_product_id = id;
    }

    public void setOrderAmount(int amount) {
        order_amount = amount;
    }

    public void setOrderDate(Date date) {
        order_date = date;
    }

    public void setProductName(String name) {
        product_name = name;
    }

    public void setProductImagePath(String path) {
        product_image_path = path;
    }

}
