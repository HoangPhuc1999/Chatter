/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Date;
import model.Product;
import model.ProductImage;

/**
 *
 * @author Hoang Phuc
 */
public class ProductDao extends DAO {

    public Product getProductById(String id) {

        Product x = null;
        int product_id = Integer.parseInt(id);
        String product_name;

        String product_title;
        String product_description;

        double price;

        xSql = "select * from products where product_id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            if (rs.next()) {

                product_name = rs.getString("product_name");
                price = rs.getFloat("product_price");
                product_title = rs.getString("product_title");
                product_description = rs.getString("product_description");
                x = new Product(product_id, product_name, "hello", price, product_title, product_description
                );

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public ProductImage getProductImageById(String id) {

        ProductImage x = new ProductImage();
        int product_id = Integer.parseInt(id);
        String imageUrl;
        Date date;

        xSql = "select * from products_image where product_id=?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, product_id);
            rs = ps.executeQuery();
            if (rs.next()) {

                imageUrl = rs.getString("product_image_path");
                date = rs.getDate("modified_at");
                x.setId(product_id);
                x.setImageUrl(imageUrl);
                x.setDate(date);

            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

}
