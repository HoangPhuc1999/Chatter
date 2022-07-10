/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Hoang Phuc
 */
public class ProductImage extends Product {

    private int id;
    private String imageUrl;
    private Date dateTime;
    private ArrayList<Category> categorys;

    public ProductImage(String imageUrl, Date dateTime, int id, String name, String image, double price, String title, String description, String cname) {
        super(id, name, image, price, title, description, cname);
        this.imageUrl = imageUrl;
        this.dateTime = dateTime;
        this.id = id;
    }

    public ProductImage() {
    }
    
    

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
        super.setId(id);
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String url) {
        this.imageUrl = url;
        super.setImage(url);
    }

    public Date getDate() {
        return dateTime;
    }

    public void setDate(Date dateTime) {
        this.dateTime = dateTime;
    }

    public ArrayList<Category> getCategorys() {
        return categorys;
    }

    public void setCategorys(ArrayList<Category> categorys) {
        this.categorys = categorys;
    }

    @Override
    public String toString() {
        return "ProductImage{" + "id=" + id + ", imageUrl=" + imageUrl + ", dateTime=" + dateTime + ", category=" + categorys +"\n"+super.toString()+ '}';
    }
    
    

}
