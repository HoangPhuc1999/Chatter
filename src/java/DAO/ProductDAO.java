/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author KQuangAn
 */
public class ProductDAO extends DAO {

    //lay product trong table product bang product id  
    //dung cho gio hang cart 
    //author: an
    //last changed by : AN
    public Product getProductById(String id) {

        xSql = "select * from products p\n"
                + "join products_image i\n"
                + "on p.product_id = i.product_id\n"
                + " where p.product_id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
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
        String query = "select p.*,c.category_name,i.product_image_path from products p\n"
                + "join products_category pc\n"
                + "on p.product_id = pc.product_id \n"
                + "join category c \n"
                + "on c.category_id = pc.category_id\n"
                + "join products_image i \n"
                + "on p.product_id = i.product_id";
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

    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        String query = "select * from category";
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(
                        rs.getInt(1),
                        rs.getString(2))
                );
            }
        } catch (Exception e) {
        }
        return list;
    }

    //author: thang 
    //Last Changed: 16/6
    public List<Product> getProductByCID(String cid) {
        List<Product> list = new ArrayList<>();
        String sql = "select p.product_id, p.product_name, i.product_image_path, "
                + "p.product_price, p.product_title, p.product_description from products p join products_image i \n"
                + "on p.product_id = i.product_id where cid = ?";

        try {
            ps = con.prepareStatement(sql);
            if (cid != null) {
                ps.setString(1, cid);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt(1),
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

    //kiem tra ma coupon hl, tra ve gia tri giam gia 
    //author: An
    public int couponCheck(String code) {
        String query = "Select * from coupons where coupon_code = ? ";
        int discount = 0;
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, code);
            rs = ps.executeQuery();
            while (rs.next()) {
                return discount = rs.getInt(3);
            }

        } catch (Exception e) {
        }
        return discount;
    }

    /**
     * Do Tuan Phong Lay tu database tat ca info ProductDetails
     *
     * type = 1 lay ra bang productid
     *
     * @param type
     * @param str
     * @return List<ProductDetails>
     */
    public List<ProductDetails> getAllProductDetailses(int type, String str) {
        ArrayList<ProductDetails> productDetailses = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM products p LEFT JOIN products_image pi ON p.product_id  = pi.product_id\n"
                + "LEFT JOIN products_inventory pin ON p.product_id = pin.product_id\n"
                + "LEFT JOIN products_category pc ON p.product_id = pc.product_id\n"
                + "JOIN category c ON pc.category_id = c.category_id\n";
        if (type == 1) {
            sql += "WHERE p.product_id like '?%'\n";
        }
        sql += "ORDER BY p.product_id";
        try {
            ps = con.prepareStatement(sql);
            if (type == 1) {
                ps.setInt(1, Integer.parseInt(str));
            }

            rs = ps.executeQuery();
            ProductDetails productDetailsTemp = new ProductDetails();
            productDetailsTemp.setId(0);

            while (rs.next()) {
                if (productDetailsTemp.getId() != rs.getInt("product_id")) {
                    productDetailsTemp.setId(rs.getInt("product_id"));

                    ProductDetails productDetails = new ProductDetails();

                    productDetails.setId(rs.getInt("product_id"));
                    productDetails.setName(rs.getString("product_name"));
                    productDetails.setTitle(rs.getString("product_title"));
                    productDetails.setQuantity(rs.getInt("product_quantity"));
                    productDetails.setPrice(rs.getDouble("product_price"));
                    productDetails.setDescription(rs.getString("product_description"));
                    productDetails.setImageUrl(rs.getString("product_image_path"));
                    productDetails.setModifyAt(rs.getTimestamp("modified_at").toLocalDateTime());
                    productDetails.setCreateAt(
                            rs.getTimestamp("created_at") != null
                            ? rs.getTimestamp("created_at").toLocalDateTime() : null);

                    if (rs.getInt(14) != 0) {
                        productDetails.setCategorys(new ArrayList<>());
                        productDetails.getCategorys().add(
                                new Category(rs.getInt("category_id"),
                                        rs.getString("category_name")));

                        productDetails.setCname(rs.getString("category_name"));

                    }

                    productDetailses.add(productDetails);

                } else {
                    productDetailses.get(productDetailses.size() - 1).getCategorys()
                            .add(new Category(rs.getInt("category_id"), rs.getString("category_name")));
                }
            }

        } catch (SQLException e) {
        }
        return productDetailses;
    }

    /**
     * Do Tuan Phong Lay tu database tat ca info ProductDetails
     *
     * @param type
     * @param str
     * @return List<ProductDetails>
     */
    public List<ProductDetails> getAllProductDetailses(int type, String str, int pageindex, int pagesize) {
        ArrayList<ProductDetails> productDetailses = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM products p LEFT JOIN products_image pi ON p.product_id  = pi.product_id\n"
                + "LEFT JOIN products_inventory pin ON p.product_id = pin.product_id\n"
                + "LEFT JOIN products_category pc ON p.product_id = pc.product_id\n"
                + "JOIN category c ON pc.category_id = c.category_id\n";
        if (type == 1) {
            sql += "WHERE p.product_id = ?\n";
        }
        sql += "ORDER BY p.product_id OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            ps = con.prepareStatement(sql);
            if (type == 1) {
                ps.setInt(1, Integer.parseInt(str));

            }
            ps.setInt(type == 1 ? 2 : 1, pageindex);
            ps.setInt(type == 1 ? 3 : 2, pagesize);

            rs = ps.executeQuery();
            ProductDetails productDetailsTemp = new ProductDetails();
            productDetailsTemp.setId(0);

            while (rs.next()) {
                if (productDetailsTemp.getId() != rs.getInt("product_id")) {
                    productDetailsTemp.setId(rs.getInt("product_id"));

                    ProductDetails productDetails = new ProductDetails();

                    productDetails.setId(rs.getInt("product_id"));
                    productDetails.setName(rs.getString("product_name"));
                    productDetails.setTitle(rs.getString("product_title"));
                    productDetails.setQuantity(rs.getInt("product_quantity"));
                    productDetails.setPrice(rs.getDouble("product_price"));
                    productDetails.setDescription(rs.getString("product_description"));
                    productDetails.setImageUrl(rs.getString("product_image_path"));
                    productDetails.setModifyAt(rs.getTimestamp(8).toLocalDateTime());
                    productDetails.setCreateAt(
                            rs.getTimestamp("created_at") != null
                            ? rs.getTimestamp("created_at").toLocalDateTime() : null);

                    if (rs.getInt("category_id") != 0) {
                        productDetails.setCategorys(new ArrayList<>());
                        productDetails.getCategorys().add(
                                new Category(rs.getInt("category_id"),
                                        rs.getString("category_name")));
                        productDetails.setCname(rs.getString("category_name"));

                    }

                    productDetailses.add(productDetails);

                } else {
                    productDetailses.get(productDetailses.size() - 1).getCategorys()
                            .add(new Category(rs.getInt("category_id"), rs.getString("category_name")));
                }
            }

        } catch (SQLException e) {
        }
        return productDetailses;
    }

    /**
     *
     * Do Tuan Phong: insert to products table
     *
     *
     * @param ProductDetails
     * @return int new product id
     */
    public int addProductDetailsToProducts(ProductDetails pd) {
        try {
            String sql = "INSERT INTO [products]\n"
                    + "           ([product_name]\n"
                    + "           ,[product_price]\n"
                    + "           ,[product_title]\n"
                    + "           ,[product_description])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, pd.getName());
            statement.setDouble(2, pd.getPrice());
            statement.setString(3, pd.getTitle());
            statement.setString(4, pd.getDescription());
            statement.executeUpdate();

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * Do Tuan Phong: update to products table
     *
     *
     * @param ProductDetails
     * @return int update column
     */
    public int updateProductDetailsToProducts(ProductDetails pd) {
        try {
            String sql = "UPDATE  [products]\n"
                    + "   SET [product_name] =?\n"
                    + "      ,[product_price] =?\n"
                    + "      ,[product_title] =?\n"
                    + "      ,[product_description] = ?\n"
                    + " WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pd.getName());
            statement.setDouble(2, pd.getPrice());
            statement.setString(3, pd.getTitle());
            statement.setString(4, pd.getDescription());
            statement.setInt(5, pd.getId());
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * Do Tuan Phong: update to products_inventory table
     *
     *
     * @param ProductDetails
     * @return int updated column
     */
    public int updateProductDetailsToProductsInventory(ProductDetails pd) {
        try {
            String sql = "UPDATE [products_inventory]\n"
                    + "   SET [product_quantity] = ?\n"
                    + "      ,[modified_at] = ?\n"
                    + " WHERE product_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, pd.getQuantity());
            statement.setTimestamp(2, Timestamp.valueOf(pd.getModifyAt()));
            statement.setInt(3, pd.getId());
            int column = statement.executeUpdate();
            if (column != 0) {
                return column;
            }
            pd.setCreateAt(pd.getModifyAt());
            return addProductDetailsToProductsInventory(pd);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     *
     * Do Tuan Phong: update to products_inventory table
     *
     *
     * @param pd
     * @return int updated column
     */
    public int updateProductDetailsToProductsImage(ProductDetails pd) {
        try {
            String sql = "UPDATE [products_image]\n"
                    + "     SET [product_image_path] =?\n"
                    + "      ,[modified_at] =?\n"
                    + " WHERE product_id= ?";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, pd.getImageUrl());
            statement.setTimestamp(2, Timestamp.valueOf(pd.getModifyAt()));
            statement.setInt(3, pd.getId());
            int column = statement.executeUpdate();
            if (column != 0) {
                return column;
            }
            return addProductDetailsToProductsImage(pd);

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Do Tuan Phong: insert to products_image table, should get productid from
     * addProductDetailsToDBproducts
     *
     * @param pd
     * @return column add to database, 0 if false
     */
    public int addProductDetailsToProductsImage(ProductDetails pd) {
        try {
            String sql = "INSERT INTO [products_image]\n"
                    + "           ([product_id]\n"
                    + "           ,[product_image_path]\n"
                    + "           ,[modified_at])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, pd.getId());
            statement.setString(2, pd.getImageUrl());
            statement.setTimestamp(3, Timestamp.valueOf(pd.getCreateAt()));
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Do Tuan Phong: insert to products_image table, should get productid from
     * addProductDetailsToDBproducts
     *
     * @return column number, 0 if false
     */
    public int addProductDetailsToProductsInventory(ProductDetails pd) {
        try {
            String sql = "INSERT INTO [products_inventory]\n"
                    + "           ([product_id]\n"
                    + "           ,[product_quantity]\n"
                    + "           ,[modified_at]\n"
                    + "           ,[created_at])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, pd.getId());
            statement.setInt(2, pd.getQuantity());
            statement.setTimestamp(3, Timestamp.valueOf(pd.getModifyAt()));
            statement.setTimestamp(4, Timestamp.valueOf(pd.getCreateAt()));
            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Do Tuan Phong: insert to products_category table, should get productid
     * from addProductDetailsToDBproducts
     *
     * @param pd
     * @return column number, 0 if no data add to database
     */
    public int addProductDetailsToProductsCategory(ProductDetails pd) {
        try {
            int size = pd.getCategorys().size();

            if (size == 0) {
                return 0;
            }

            String sql = "INSERT INTO [products_category]\n"
                    + "           ([product_id]\n"
                    + "           ,[category_id])\n"
                    + "     VALUES\n";

            for (int i = 0; i < size; i++) {
                sql += "           (?\n"
                        + "           ,?)" + (i == size - 1 ? "" : ",\n");
            }

            PreparedStatement statement = connection.prepareStatement(sql);

            for (int i = 0; i < size; i++) {
                statement.setInt(2 * i + 1, pd.getId());
                statement.setInt(2 * i + 2, pd.getCategorys().get(i).getCid());
            }

            return statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * Do Tuan Phong: delete to products_category table, should get productid
     * from addProductDetailsToDBproducts
     *
     * @param pd
     * @return boolean: is executeUpdate successful deleted to Database
     */
    public boolean deleteProductDetailsToProductsCategory(ProductDetails pd) {
        try {
            String sql = "DELETE FROM [products_category]\n"
                    + "      WHERE product_id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pd.getId());
            return statement.executeUpdate() != 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Do Tuan Phong: update to products_category table, should get productid
     * from addProductDetailsToDBproducts
     *
     * @param pd
     * @return boolean: is executeUpdate successful update to Database
     */
    public int updateProductDetailsToProductsCategory(ProductDetails pd) {
        deleteProductDetailsToProductsCategory(pd);
        return addProductDetailsToProductsCategory(pd);
    }

    /**
     * Do Tuan Phong: add to all table using 4 other update method
     *
     * @param pd
     * @return info of 4 subs method
     */
    public String addProductDetails(ProductDetails pd) {
        int pdid = addProductDetailsToProducts(pd);
        pd.setId(pdid);
        return "\nProduct table: product ID = " + pdid
                + "\nProduct_image table:" + addProductDetailsToProductsImage(pd)
                + "\nInventory table: " + addProductDetailsToProductsInventory(pd)
                + "\nProduct_category table: " + addProductDetailsToProductsCategory(pd);
    }

    /**
     * Do Tuan Phong: update to all table using 4 other update method
     *
     * @param pd
     * @return String: info of 4 subs method
     */
    public String updateProductDetails(ProductDetails pd) {
        return "\nProduct table: " + updateProductDetailsToProducts(pd)
                + "\nProduct_image table:" + updateProductDetailsToProductsImage(pd)
                + "\nInventory table: " + updateProductDetailsToProductsInventory(pd)
                + "\nProduct_category table: " + updateProductDetailsToProductsCategory(pd);
    }

    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
//        List<Product> list = dao.getProductByCID(cid);
//        for (Product o : list) {
//            System.out.println(o);
//        }
        //System.out.println(dao.getAllProductWithCategory());

    }

}
