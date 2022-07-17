/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import model.OrderAnalysis;
import model.OrderDetail;
import model.SaleInfo;

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
                + "join products_image on orders_details.order_product_id = products_image.product_id\n"
                + "ORDER BY order_id ASC";

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

    public List<OrderDetail> getAllOrderDetailByID(String id) {
        List<OrderDetail> list = new ArrayList<>();
        xSql = "select orders_details.order_id, orders_details.order_product_id,orders_details.order_amount,orders_details.order_date,products.product_name,products_image.product_image_path\n"
                + "from orders_details\n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "join products_image on orders_details.order_product_id = products_image.product_id\n"
                + "where order_id = ?";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
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

    public List<OrderAnalysis> getOrderAnalysisTop5() {
        List<OrderAnalysis> list = new ArrayList<>();
        xSql = "select top 5 orders_details.order_product_id, products.product_price, products.product_name,sum(orders_details.order_amount) as totalamount,\n"
                + "(product_price * sum(orders_details.order_amount)) as revenue\n"
                + "from orders_details \n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "group by orders_details.order_product_id,products.product_price, products.product_name\n"
                + "order by revenue DESC";
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            while (rs.next()) {
                OrderAnalysis x = new OrderAnalysis();

                x.setOrderProductId(rs.getInt("order_product_id"));
                x.setProductPrice(rs.getInt("product_price"));
                x.setProductName(rs.getString("product_name"));
                x.setTotalAmount(rs.getInt("totalamount"));
                x.setRevenue(rs.getDouble("revenue"));
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

    public SaleInfo getTodaySale() {
        SaleInfo x = new SaleInfo();
        xSql = "select * from \n"
                + "(\n"
                + "select sum(subquery.revenue) as total_revenue, subquery.order_date\n"
                + "from \n"
                + "(\n"
                + "select orders_details.order_product_id, products.product_price, products.product_name,sum(orders_details.order_amount) as totalamount,\n"
                + "(product_price * sum(orders_details.order_amount)) as revenue, CAST(orders_details.order_date AS DATE)as order_date \n"
                + "from orders_details \n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "group by orders_details.order_product_id,products.product_price, products.product_name, CAST(orders_details.order_date AS DATE)\n"
                + ") as subquery\n"
                + "group by  subquery.order_date\n"
                + ") as subtable\n"
                + "where  subtable.order_date = CAST(GETDATE() AS DATE) ";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                x.setTotalRevenue(rs.getDouble("total_revenue"));
                x.setOrderDate(rs.getDate("order_date"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Get Total Sale Fail");
            e.printStackTrace();
        }
        return (x);
    }

    public SaleInfo getTotalSale() {
        SaleInfo x = new SaleInfo();
        xSql = "select sum(subquery.revenue) as total_revenue\n"
                + "from  \n"
                + "(\n"
                + "select orders_details.order_product_id, products.product_price, products.product_name,sum(orders_details.order_amount) as totalamount,\n"
                + "(product_price * sum(orders_details.order_amount)) as revenue, CAST(orders_details.order_date AS DATE)as order_date\n"
                + "from orders_details \n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "group by orders_details.order_product_id,products.product_price, products.product_name, CAST(orders_details.order_date AS DATE)\n"
                + ") as subquery";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            if (rs.next()) {
                x.setTotalRevenue(rs.getDouble("total_revenue"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Get Total Sale Fail");
            e.printStackTrace();
        }
        return (x);
    }

    public List<SaleInfo> getMostRecentTotalSale() {
        List<SaleInfo> list = new ArrayList<>();
        xSql = "select top 5 sum(subquery.revenue) as total_revenue, subquery.order_date\n"
                + "from  \n"
                + "(\n"
                + "select orders_details.order_product_id, products.product_price, products.product_name,sum(orders_details.order_amount) as totalamount,\n"
                + "(product_price * sum(orders_details.order_amount)) as revenue, CAST(orders_details.order_date AS DATE)as order_date\n"
                + "from orders_details  \n"
                + "join products on orders_details.order_product_id = products.product_id\n"
                + "group by orders_details.order_product_id,products.product_price, products.product_name, CAST(orders_details.order_date AS DATE)\n"
                + ") as subquery\n"
                + "group by  subquery.order_date\n";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SaleInfo x = new SaleInfo();
                x.setTotalRevenue(rs.getDouble("total_revenue"));
                x.setOrderDate(rs.getDate("order_date"));
                list.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Get Recent Sale Fail");
            e.printStackTrace();
        }
        return list;
    }

}
