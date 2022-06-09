/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import context.DBContext;
import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author KQuangAn
 */
public class PackageDAO extends DAO{

    //lay product trong table product bang product id  
    //dung cho gio hang cart 
    //author: an 
    public Product getProductById(int id) {

        xSql = "select * from product where product_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Product(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                );

            } else {
                x = null;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
        }
        return (x);
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

    
    
    
}
