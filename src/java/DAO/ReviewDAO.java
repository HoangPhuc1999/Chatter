/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
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

    public List<Review> getAllReviews() {
        List<Review> list = new ArrayList<>();
        xSql = "select * from products_review";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Review x = new Review();
                x.setReviewId(rs.getInt("review_id"));
                x.setProductId(rs.getInt("product_id"));
                x.setTitle(rs.getString("title"));
                x.setReviewContent(rs.getString("review_content"));
                x.setRating(rs.getString("rating"));
                x.setReviewImageUrl(rs.getString("review_image_path"));
                x.setDate(rs.getDate("created_at"));
                x.setUserId(rs.getInt("users_id"));
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (list);

    }

    public List<Review> getAllReviewsFromId(String id) {
        List<Review> list = new ArrayList<>();
        xSql = "select * from products_review where product_id = ?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Review x = new Review();
                x.setReviewId(rs.getInt("review_id"));
                x.setProductId(rs.getInt("product_id"));
                x.setTitle(rs.getString("title"));
                x.setReviewContent(rs.getString("review_content"));
                x.setRating(rs.getString("rating"));
                x.setReviewImageUrl(rs.getString("review_image_path"));
                x.setDate(rs.getDate("created_at"));
                x.setUserId(rs.getInt("users_id"));
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (list);

    }

    public String getReviewAuthor(int id) {
        String name = "";
        xSql = "select * from users_account where users_id = ?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString("username");
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
        }

        return name;
    }

}
