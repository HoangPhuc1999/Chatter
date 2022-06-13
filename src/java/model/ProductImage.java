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
public class ProductImage {

    private int id;
    private String imageUrl;
    private Date dateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
    }

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date dateTime) {
        this.dateTime = dateTime;
    }

}
