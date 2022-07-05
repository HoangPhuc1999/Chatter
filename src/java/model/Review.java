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
public class Review {

    private int review_id;
    private int product_id;
    private String title;
    private String review_content;
    private String rating;
    private String review_image_path;
    private int users_id;
    private Date date;
    private String user_name;

    public String getName() {
        return user_name;
    }

    public void setName(String name) {
        user_name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getReviewContent() {
        return review_content;
    }

    public String getReviewImageUrl() {
        return review_image_path;
    }

    public Date getDate() {
        return date;
    }

    public int getReviewId() {
        return review_id;
    }

    public int getProductId() {
        return product_id;
    }

    public String getRating() {
        return rating;
    }

    public int getUserId() {
        return users_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReviewContent(String reviewContent) {
        this.review_content = reviewContent;
    }

    public void setReviewImageUrl(String url) {
        this.review_image_path = url;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setReviewId(int id) {
        this.review_id = id;
    }

    public void setProductId(int id) {
        this.product_id = id;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setUserId(int id) {
        this.users_id = id;
    }

}
