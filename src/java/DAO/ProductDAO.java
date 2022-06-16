/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import context.DBContext;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author KQuangAn
 */
public class ProductDAO extends DAO{

    //lay product trong table product bang product id  
    //dung cho gio hang cart 
    //author: an
    //last changed by : AN
    public Product getProductById(String id) {

        xSql = "select * from products p\n" +
                "join products_image i\n" +
                "on p.product_id = i.product_id\n" +
                " where p.product_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()) {
                return new Product(rs.getInt(1),//id
                        rs.getString(2),//name
                        rs.getString(7),//image
                        rs.getDouble(3),//price
                        rs.getString(4),//title
                        rs.getString(5)//description
                );
            } 
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return null;
    }
   
    //lay tat ca product cho vao arraylist (co lay image) 
    //dung cho index.jsp
    //author an 
    public List<Product> getAllProduct() {
        List<Product> list = new ArrayList<>();
        String query = "select p.product_id , p.product_name , p.product_price , i.product_image_path,"
                + "p.product_title,p.product_description"
                + " from products p"
                + " Join products_image i"
                + " on p.product_id = i.product_id";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    //lay tat ca product co category cho vao arraylist (co lay image) 
    //dung cho index.jsp
    //author an 
    public List<Product> getAllProductWithCategory() {
        List<Product> list = new ArrayList<>();
        String query = "select p.*,c.category_name,i.product_image_path from products p\n" +
                        "join products_category pc\n" +
                        "on p.product_id = pc.product_id \n" +
                        "join category c \n" +
                        "on c.category_id = pc.category_id\n" +
                        "join products_image i \n" +
                        "on p.product_id = i.product_id";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1),//id
                        rs.getString(2),//name
                        rs.getString(7),//image
                        rs.getDouble(3),//price
                        rs.getString(4),//title
                        rs.getString(5),//des
                        rs.getString(6)));//cname
            }
        } catch (Exception e) {
        }
        return list;
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
