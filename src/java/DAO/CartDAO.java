/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

/**
 *
 * @author KQuangAn
 */
public class CartDAO extends DAO {

    //kiem tra ma coupon hl, tra ve gia tri giam gia
    //author:An
    public int couponCheck(String code) {
         
        String query = "Select * from coupons where coupon_code = ? ";
        int discount=0;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1,code);
            rs=ps.executeQuery();
            while(rs.next()){
                return discount=rs.getInt(3);
            }
            
        } catch (Exception e) {
        }
        return discount;
    }
}
