/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.OrderDetail;

/**
 *
 * @author Hoang Phuc
 */
public class OrderDetailDAO extends DAO {

    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> list = new ArrayList<>();
        xSql = "select orders_details.order_id, orders_details.order_product_id,orders_details.order_amount,orders_details.order_date,products.product_name,products_image.product_image_path\n"
                + "from orders_details\n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "join products_image on orders_details.order_product_id = products_image.product_id\n";

        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                OrderDetail x = new OrderDetail();
                x.setOrderId(rs.getInt("order_id"));
                x.setOrderProductId(rs.getInt("order_product_id"));
                x.setOrderAmount(rs.getInt("order_amount"));
                x.setOrderDate(rs.getDate("order_date"));
                x.setProductName(rs.getString("product_name"));
                x.setProductImagePath(rs.getString("product_image_path"));
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Get Order Detail Fail");
            e.printStackTrace();
        }
        return (list);

    }

}
