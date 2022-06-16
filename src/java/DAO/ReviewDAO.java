/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import model.Review;

/**
 *
 * @author Hoang Phuc
 */
public class ReviewDAO extends DAO {

    public void postReview(Review reviewItem) {
        String query = "INSERT INTO  [Chatter].[dbo].[products_review](product_id,title,review_content,rating,review_image_path,created_at,users_id)"
                + "VALUES(?,?,?,?,?,?,?)";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, reviewItem.getProductId());
            ps.setString(2, reviewItem.getTitle());
            ps.setString(3, reviewItem.getReviewContent());
            ps.setString(4, reviewItem.getRating());
            ps.setString(5, reviewItem.getReviewImageUrl());
            ps.setDate(6, reviewItem.getDate());
            ps.setInt(7, reviewItem.getUserId());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
