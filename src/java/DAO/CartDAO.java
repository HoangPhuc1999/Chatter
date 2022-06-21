/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import java.util.ArrayList;
import java.util.List;
import model.Item;
import model.Product;

/**
 *
 * @author KQuangAn
 */
public class CartDAO extends MyDAO{
  
    //them gio hang cua nguoi dung vao bang user cart moi khi nguoi dung them mon hang
    //neu da co thi update 
    //author an 
    public void updateCartInDB(int users_id, int product_id, int amount) {
//            String query = "Update users_cart\n" +
//                            "set order_amount =? \n" +
//                            "where users_id=?\n" +
//                            "and product_id=?";
            
            String query ="IF EXISTS (SELECT * FROM users_cart WHERE users_id=? and product_id=?)\n" +
                        "    UPDATE users_cart SET order_amount=? WHERE users_id=? and product_id=?\n" +
                        "       ELSE\n" +
                        "    INSERT INTO users_cart(users_id,product_id,order_amount) VALUES (?,?,?)";
            
            String deleteQuery ="delete from users_cart WHERE users_id=? and product_id=?";
                    
        try {
            if(amount>0){
                ps = con.prepareStatement(query);
                ps.setInt(1,users_id);
                ps.setInt(2,product_id);

                ps.setInt(3,amount);
                ps.setInt(4,users_id);
                ps.setInt(5,product_id);

                ps.setInt(6,users_id);
                ps.setInt(7,product_id);
                ps.setInt(8,amount);

                ps.executeUpdate();
            }
            else{
                ps = con.prepareStatement(deleteQuery);
                ps.setInt(1,users_id);
                ps.setInt(2,product_id);

                ps.executeUpdate();
            }
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
    //Lay gio hang cua nguoi dung moi khi sign in
    //author an 
    //20/6/2022
    public List<Item> getCart(int users_id) {
        List<Item> list = new ArrayList<>();
        ProductDAO pdao = new ProductDAO();
        String query = "select * from users_cart\n" +
                        "where users_id = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, users_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Item(pdao.getProductById((rs.getString(2))), rs.getInt(3) ));   // get prodcutid - amount 
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }
    
    public static void main(String[] args) {
        CartDAO dao = new CartDAO();
        dao.updateCart(1, 7, 45);
        //System.out.println(dao.getCart(1));
        //dao.updateCart(1, 3, 69);
    }
    
    
}
