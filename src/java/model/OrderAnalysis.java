/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hoang Phuc
 */
public class OrderAnalysis {

    private int order_product_id;
    private double product_price;
    private String product_name;
    private int totalamount;
    private double revenue;

    public int getOrderProductId() {
        return order_product_id;
    }

    public double getProductPrice() {
        return product_price;
    }

    public String getProductName() {
        return product_name;
    }

    public int getTotalAmount() {
        return totalamount;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setOrderProductId(int id) {
        order_product_id = id;
    }

    public void setProductPrice(double price) {
        product_price = price;
    }

    public void setProductName(String name) {
        product_name = name;
    }

    public void setTotalAmount(int id) {
        totalamount = id;
    }

    public void setRevenue(double i) {
        revenue = i;
    }

}
