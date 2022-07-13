/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import model.Item;

/**
 *
 * @author KQuangAn
 */
public class OrderDAO extends MyDAO{

    //them order vao bang order, order detail sau khi nguoi dung mua hang
    //author an 
    //27/6/2022
    public void insertOrder(ArrayList<Item> list, int users_id) {
        String query = "Insert into orders(order_by)"
                        + "Values(?)";
        String query2 ="Insert into orders_details(order_id,order_product_id,order_amount)"
                        + "Values(?,?,?)";
        String idquery = "SELECT order_id \n" +
                        "FROM orders\n" +
                        "WHERE order_id = (SELECT MAX(order_id) FROM orders)";
        
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            ps.executeUpdate();
            ps.clearParameters();
            
            //get newest order_id to insert order details 
            int order_id=0;
            ps = con.prepareStatement(idquery);
            rs = ps.executeQuery();
            while (rs.next()) {
                order_id = rs.getInt(1);
            }
            ps.clearParameters();
            
            //insert to order details
            Iterator<Item> iterator = list.iterator();
            while (iterator.hasNext()){
                ps = con.prepareStatement(query2);
                ps.setInt(1, order_id);
                ps.setInt(2, iterator.next().getProduct().getId());
                ps.setInt(3, iterator.next().getQuantity());
                ps.executeUpdate();
                ps.clearParameters();
            }
            
            } catch (Exception e) {
                System.out.println(e.toString());
            }
    }
    
    
    
}
