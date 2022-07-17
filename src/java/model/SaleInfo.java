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
public class SaleInfo {

    private double total_revenue;
    private Date order_date;

    public double getTotalRevenue() {
        return total_revenue;
    }

    public Date getOrderDate() {
        return order_date;
    }

    public void setTotalRevenue(double number) {
        total_revenue = number;
    }

    public void setOrderDate(Date date) {
        order_date = date;
    }

}
